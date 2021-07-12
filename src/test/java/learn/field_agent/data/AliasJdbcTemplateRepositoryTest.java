package learn.field_agent.data;

import learn.field_agent.models.Agent;
import learn.field_agent.models.Alias;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AliasJdbcTemplateRepositoryTest {

    @Autowired
    AliasJdbcTemplateRepository repository;

    final static int NEXT_ID = 4;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindAll() {
        List<Alias> aliases = repository.findAll();
        assertNotNull(aliases);
        assertTrue(aliases.size() >= 2 && aliases.size() <= 10);
    }

    @Test
    void shouldFindId() {
        Alias alias = repository.findById(1);
        assertEquals(1, alias.getAlias_id());
        assertEquals("Alford", alias.getName());
        assertEquals(2, alias.getAgent_id());
    }

    @Test
    void shouldAdd() {
        // all fields
        Alias alias = new Alias();
        alias.setAgent_id(1);
        alias.setName("harvey");
        Alias actual = repository.add(alias);
        assertNotNull(actual);
        assertEquals(NEXT_ID, actual.getAlias_id());
    }

    @Test
    void shouldUpdate() {
        Alias alias = repository.findById(1);
        alias.setName("Jack Dull");
        assertTrue(repository.update(alias));
        alias.setAlias_id(13);
        assertFalse(repository.update(alias));
    }

    @Test
    void shouldDelete() {
        assertTrue(repository.deleteById(3));
        assertFalse(repository.deleteById(3));
    }
}

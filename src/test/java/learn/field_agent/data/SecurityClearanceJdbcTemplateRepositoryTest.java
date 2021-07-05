package learn.field_agent.data;

import learn.field_agent.models.SecurityClearance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SecurityClearanceJdbcTemplateRepositoryTest {

    @Autowired
    SecurityClearanceJdbcTemplateRepository repository;

//    public SecurityClearanceJdbcTemplateRepositoryTest() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(DbTestConfig.class);
//        repository = context.getBean(SecurityClearanceJdbcTemplateRepository.class);
//    }

//    @BeforeAll
//    static void oneTimeSetup() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(DbTestConfig.class);
//        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//        jdbcTemplate.update("call set_known_good_state();");
//    }

    final static int NEXT_ID = 9;

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
        List<SecurityClearance> securityClearances = repository.findAll();
        assertNotNull(securityClearances);
        assertTrue(securityClearances.size() >= 2);
    }

    @Test
    void shouldFindById() {
        SecurityClearance secret = new SecurityClearance(1, "Secret");
        SecurityClearance topSecret = new SecurityClearance(2, "Top Secret");

        SecurityClearance actual = repository.findById(1);
        assertEquals(secret, actual);

        actual = repository.findById(2);
        assertEquals(topSecret, actual);

        actual = repository.findById(100);
        assertEquals(null, actual);
    }

    @Test
    void shouldAddSecurityClearance() {
        // all fields
        SecurityClearance securityClearance1 = new SecurityClearance();
        securityClearance1.setName("testAdd1");
        SecurityClearance actual = repository.add(securityClearance1);
        assertNotNull(actual);
        assertEquals(NEXT_ID, actual.getSecurityClearanceId());

        // null dob
        SecurityClearance securityClearance2 = new SecurityClearance();
        securityClearance2.setName("testAdd2");
        actual = repository.add(securityClearance2);
        assertNotNull(actual);
        assertEquals(NEXT_ID + 1, actual.getSecurityClearanceId());
}

    @Test
    void shouldUpdateSecurityClearance() {
        SecurityClearance securityClearance = new SecurityClearance();
        securityClearance.setSecurityClearanceId(3);
        securityClearance.setName("TEST");

        assertTrue(repository.update(securityClearance));
    }

    @Test
    void shouldDeleteSecurityClearance() {
        int securityClearanceId = 12;
        assertTrue(repository.deleteById(securityClearanceId));
    }

}
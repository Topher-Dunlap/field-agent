package learn.field_agent.domain;

import learn.field_agent.data.AliasRepository;
import learn.field_agent.models.Alias;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AliasServiceTest {

    @Autowired
    AliasService service;

    @MockBean
    AliasRepository repository;

    @Test
    void shouldFindAll() {
        List<Alias> expected = service.findAll();
        when(repository.findAll()).thenReturn(expected);
        List<Alias> actual = service.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindId() {
        Alias expected = service.findById(1);
        when(repository.findById(1)).thenReturn(expected);
        Alias actual = service.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindIfIdDoesNotExist() {
        Alias expected = service.findById(0);
        when(repository.findById(0)).thenReturn(expected);
        Alias actual = service.findById(0);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddWhenInvalid() {
        Alias alias = new Alias();
        Result<Alias> result = service.add(alias);
        assertEquals(ResultType.INVALID, result.getType());

        alias.setAlias_id(0);
        alias.setName(null);
        result = service.add(alias);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotDeleteWhenIdDoesNotExist() {
        int alias_id = 1000;
        Result<Boolean> result = new Result<>();
        result.setPayload(service.deleteById(alias_id));
        assertEquals(false, result.getPayload());
    }

}

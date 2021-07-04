package learn.field_agent.domain;

import learn.field_agent.data.SecurityClearanceRepository;
import learn.field_agent.models.SecurityClearance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SecurityClearanceServiceTest {

    @Autowired
    SecurityClearanceService service;

    @MockBean
    SecurityClearanceRepository repository;

    @Test
    void shouldFindAll() {
        List<SecurityClearance> expected = service.findAll();
        when(repository.findAll()).thenReturn(expected);
        List<SecurityClearance> actual = service.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindId() {
        SecurityClearance expected = service.findById(1);
        when(repository.findById(1)).thenReturn(expected);
        SecurityClearance actual = service.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindIfIdDoesNotExist() {
        SecurityClearance expected = service.findById(0);
        when(repository.findById(0)).thenReturn(expected);
        SecurityClearance actual = service.findById(0);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddWhenInvalid() {
        SecurityClearance securityClearance = new SecurityClearance();
        Result<SecurityClearance> result = service.add(securityClearance);
        assertEquals(ResultType.INVALID, result.getType());

        securityClearance.setSecurityClearanceId(0);
        securityClearance.setName(null);
        result = service.add(securityClearance);
        assertEquals(ResultType.INVALID, result.getType());
    }

//    @Test
//    void shouldNotAddWhenValid() {
//        SecurityClearance expected = new SecurityClearance();
//        SecurityClearance arg = new SecurityClearance();
//        arg.setSecurityClearanceId(0);
//
//        when(repository.add(arg)).thenReturn(expected);
//        Result<SecurityClearance> result = service.add(arg);
//        assertEquals(ResultType.SUCCESS, result.getType());
//
//        assertEquals(expected, result.getPayload());
//    }
}

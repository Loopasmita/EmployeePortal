package com.company.employeePortal;

import com.company.employeePortal.api.dto.EmployeeListDto;
import com.company.employeePortal.service.data.EmployeeRepository;
import com.company.employeePortal.service.entity.EmployeeEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeePortalApplicationTests {

    EmployeeEntity employeeEntity;
    @Autowired
    private TestRestTemplate anonymousRestTemplate;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void checkHealth() throws Exception {
        ResponseEntity<String> response = anonymousRestTemplate.getForEntity("/health", String.class);
        Assert.assertTrue(response.getStatusCode().value() == 200);
    }

    @Before
    void setUp() {
        employeeEntity = new EmployeeEntity("Loopa", "Deka", "Female", "31-07-1994", "IT");
        employeeEntity = employeeRepository.save(employeeEntity);
    }

    @Test
    public void testGetEmployeeApi() {
        String url = "/api/employee/list";
        ResponseEntity<EmployeeListDto> response = anonymousRestTemplate.getForEntity(url, EmployeeListDto.class);
        EmployeeListDto body = response.getBody();
        Assert.assertNotNull("Live Header Summary Response should not be null", body);
        Assert.assertTrue(response.getStatusCode().value() == 200);
    }

    @Test
    public void testRegisterApi() {
        String url = "/api/employee/register?firstName=Loopa&lastName=Deka&gender=female&dob=31-07-1994&department=IT";
        ResponseEntity<EmployeeEntity> response = anonymousRestTemplate.getForEntity(url, EmployeeEntity.class);
        EmployeeEntity body = response.getBody();
        Assert.assertNotNull("Live Header Summary Response should not be null", body);
        Assert.assertTrue(response.getStatusCode().value() == 200);
    }
}

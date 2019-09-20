package com.company.employeePortal.service.controller;

import com.company.employeePortal.api.controller.IEmployeePortal;
import com.company.employeePortal.api.dto.EmployeeDto;
import com.company.employeePortal.api.dto.EmployeeListDto;
import com.company.employeePortal.service.mapper.EmployeeMapper;
import com.company.employeePortal.service.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Slf4j
@RestController
public class EmployeePortalController implements IEmployeePortal {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public EmployeeListDto getEmployeeList() {
        EmployeeMapper employeeMapper = new EmployeeMapper();
        return employeeMapper.toDto(employeeService.getAllEmployeeList());
    }

    @Override
    public EmployeeDto addEmployee(@Valid EmployeeDto employeeInfo) {
        EmployeeMapper employeeMapper = new EmployeeMapper();
        String fName = employeeInfo.getFirstName();
        String lName = employeeInfo.getLastName();
        String gender = employeeInfo.getGender();
        String dob = employeeInfo.getDob();
        String dept = employeeInfo.getDepartment();
        return employeeMapper.toDto(employeeService.registerEmployee(fName, lName, gender, dob, dept));
    }

    public void explorer(HttpServletResponse res) {
        try {
            res.sendRedirect("/swagger-ui.html");
        } catch (IOException e) {
            log.error("Could not redirect to swagger ui " + e);
        }
    }
}

package com.company.employeePortal.api.controller;

import com.company.employeePortal.api.dto.EmployeeDto;
import io.swagger.annotations.ApiOperation;
import com.company.employeePortal.api.dto.EmployeeListDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

public interface IEmployeePortal {
    @ApiOperation(value = "Get Employee List",
            response = EmployeeListDto.class)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = API.EMPLOYEE_LIST)
    EmployeeListDto getEmployeeList();

    @ApiOperation(value = "Register an employee")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = API.REGISTER)
    EmployeeDto addEmployee(@RequestBody @Valid EmployeeDto employeeInfo);

    @RequestMapping(value = "/explorer", method = RequestMethod.GET)
    void explorer(HttpServletResponse res);

    class API {
        static final String EMPLOYEE_LIST = "/api/employee/list";
        static final String REGISTER = "/api/employee/register";

        private API() {
        }
    }
}

package com.company.employeePortal.service.services;

import com.company.employeePortal.service.data.EmployeeRepository;
import com.company.employeePortal.service.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployeeList() {
        return Optional.ofNullable(employeeRepository.findAll()).orElse(new ArrayList<>());
    }

    public EmployeeEntity registerEmployee(String fistName, String lastName, String gender, String dob, String dept) {
        return Optional.ofNullable(employeeRepository.save(new EmployeeEntity(fistName, lastName, gender, dob, dept))).orElse(new EmployeeEntity());
    }
}

package com.company.employeePortal.service.mapper;

import com.company.employeePortal.api.dto.EmployeeDto;
import com.company.employeePortal.api.dto.EmployeeListDto;
import com.company.employeePortal.service.entity.EmployeeEntity;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public EmployeeDto toDto(EmployeeEntity entity) {
        return new EmployeeDto(entity.getFirstName(), entity.getLastName(), entity.getGender(), entity.getDob(), entity.getDepartment());
    }

    public EmployeeListDto toDto(List<EmployeeEntity> list) {
        List<EmployeeDto> dtoList;
        dtoList = list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return new EmployeeListDto(dtoList);
    }
}

package com.company.employeePortal.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EmployeeListDto {
    List<EmployeeDto> employeeList;
}

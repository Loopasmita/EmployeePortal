package com.company.employeePortal.service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private String dob;
    private String department;

    public EmployeeEntity(String firstName, String lastName, String gender, String dob, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.department = department;
    }
}
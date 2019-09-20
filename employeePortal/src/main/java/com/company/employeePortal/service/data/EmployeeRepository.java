package com.company.employeePortal.service.data;

import com.company.employeePortal.service.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

    List<EmployeeEntity> findAll();
}

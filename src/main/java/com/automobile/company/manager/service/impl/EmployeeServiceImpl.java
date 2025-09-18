package com.automobile.company.manager.service.impl;

import com.automobile.company.manager.entity.EmployeeEntity;
import com.automobile.company.manager.repository.EmployeeRepository;
import com.automobile.company.manager.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }
}

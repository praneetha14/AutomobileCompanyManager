package com.automobile.company.manager.service.facade;

import com.automobile.company.manager.entity.EmployeeEntity;
import com.automobile.company.manager.model.dto.EmployeeDTO;
import com.automobile.company.manager.model.enums.EmployeeDepartment;
import com.automobile.company.manager.service.EmployeeService;
import com.automobile.company.manager.service.impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class EmployeeFacade {

    private final EmployeeService employeeService;

    public UUID createEmployee(EmployeeDTO employeeDTO) {
        checkDesignation(employeeDTO.getDesignation(), employeeDTO.getDepartment());
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(employeeDTO.getFirstName());
        employeeEntity.setLastName(employeeDTO.getLastName());
        employeeEntity.setEmail(employeeDTO.getEmail());
        employeeEntity.setPhoneNumber(employeeDTO.getPhoneNumber());
        employeeEntity.setAge(employeeDTO.getAge());
        employeeEntity.setAddress(employeeDTO.getAddress());
        employeeEntity.setDesignation(employeeDTO.getDesignation());
        employeeEntity.setDepartment(employeeDTO.getDepartment());
        employeeEntity.setDateOfJoining(employeeDTO.getDateOfJoining());
        employeeEntity.setSalary(employeeDTO.getSalary());
        employeeEntity.setStatus(employeeDTO.getStatus());
        employeeEntity = employeeService.createEmployee(employeeEntity);
        return employeeEntity.getId();
    }

    private void checkDesignation(String designation, String department) {
        if(!EmployeeDepartment.departmentDesignationMap.containsKey(department)) {
            throw new RuntimeException("Please enter valid designation: " + department);
        }
        if(!EmployeeDepartment.departmentDesignationMap.get(department).contains(designation)) {
            throw new RuntimeException("Please enter valid designation: " + designation);
        }
    }
}

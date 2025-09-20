package com.automobile.company.manager.service.facade;

import com.automobile.company.manager.entity.EmployeeEntity;
import com.automobile.company.manager.model.dto.EmployeeDTO;
import com.automobile.company.manager.model.enums.EmployeeDepartment;
import com.automobile.company.manager.model.enums.EmployeeDesignation;
import com.automobile.company.manager.repository.EmployeeRepository;
import com.automobile.company.manager.service.EmployeeService;
import com.automobile.company.manager.service.impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class EmployeeFacade {

    private final EmployeeService employeeService;

    private final EmployeeRepository employeeRepository;

    public UUID createEmployee(EmployeeDTO employeeDTO) {
        checkDesignation(employeeDTO.getDesignation(), employeeDTO.getDepartment());
        performValidations(employeeDTO);
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

    private void checkDesignation(EmployeeDesignation designation, EmployeeDepartment department) {
        if(!EmployeeDepartment.departmentDesignationMap.containsKey(department)) {
            throw new RuntimeException("Please enter valid designation: " + department);
        }
        if(!EmployeeDepartment.departmentDesignationMap.get(department).contains(designation)) {
            throw new RuntimeException("Please enter valid designation: " + designation);
        }
    }

    private void performValidations(EmployeeDTO employeeDTO) {
        if(employeeDTO.getPhoneNumber().length() != 10){
            throw new RuntimeException("Please enter valid phone number");
        }
        if(!employeeDTO.getEmail().endsWith("@gmail.com")){
            throw new RuntimeException("Please enter valid email");
        }
        if(employeeRepository.existsByEmail(employeeDTO.getEmail())){
            throw new RuntimeException("Employee with this Email already exists" + employeeDTO.getEmail());
        }
        if(employeeRepository.existsByPhoneNumber(employeeDTO.getPhoneNumber())){
            throw new RuntimeException("Employee with this Phone already exists" + employeeDTO.getPhoneNumber());
        }
    }
}

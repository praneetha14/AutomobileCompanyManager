package com.automobile.company.manager.model.dto;

import com.automobile.company.manager.model.enums.EmployeeDepartment;
import com.automobile.company.manager.model.enums.EmployeeDesignation;
import com.automobile.company.manager.model.enums.EmployeeGender;
import com.automobile.company.manager.model.enums.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Integer age;
    private EmployeeGender gender;
    private String address;
    private EmployeeDesignation designation;
    private EmployeeDepartment department;
    private double salary;
    private String dateOfJoining;
    private EmployeeStatus status;
}

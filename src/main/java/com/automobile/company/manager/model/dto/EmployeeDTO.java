package com.automobile.company.manager.model.dto;

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
    private String gender;
    private String address;
    private String designation;
    private String department;
    private double salary;
    private LocalDate dateOfJoining;
    private String status;
}

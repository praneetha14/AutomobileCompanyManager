package com.automobile.company.manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Employee_table")
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "designation")
    @Enumerated(EnumType.STRING)
    private String designation;

    @Column(name = "department")
    @Enumerated(EnumType.STRING)
    private String department;

    @Column(name = "salary")
    private double salary;

    @Column(name = "date_of_joining")
    private LocalDate dateOfJoining;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private String status;
}

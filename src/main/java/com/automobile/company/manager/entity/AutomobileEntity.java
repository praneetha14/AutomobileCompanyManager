package com.automobile.company.manager.entity;

import com.automobile.company.manager.model.enums.Brand;
import com.automobile.company.manager.model.enums.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Entity
@Table(name = "automobiles")
@Getter
@Setter
public class AutomobileEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "registration_number")
    private String RegistrationNumber;

    @Column(name = "model_year")
    private Integer modelYear;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "brand")
    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Column(name = "model")
    @Enumerated(EnumType.STRING)
    private Model model;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerEntity customerEntity;

}

package com.automobile.company.manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customer_table")
@Getter
@Setter
public class CustomerEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_address")
    private String customerAddress;

    @OneToMany(mappedBy = "customerEntity")
    private List<AutomobileEntity> automobileEntities;
}

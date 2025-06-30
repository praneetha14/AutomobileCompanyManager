package com.automobile.company.manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CustomerLogin")
@Getter
@Setter
public class UserEntity {
    @Id
    @Column(unique = true, nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;
}

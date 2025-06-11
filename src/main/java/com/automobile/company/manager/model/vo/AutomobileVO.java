package com.automobile.company.manager.model.vo;

import com.automobile.company.manager.model.enums.Brand;
import com.automobile.company.manager.model.enums.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
public class AutomobileVO {
    private UUID id;
    private String registrationNumber;
    private Integer modelYear;
    private Integer numberOfSeats;
    private Integer mileage;
    private Brand brand;
    private Model model;
}

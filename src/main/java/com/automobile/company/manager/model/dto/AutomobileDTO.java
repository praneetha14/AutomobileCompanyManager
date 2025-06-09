package com.automobile.company.manager.model.dto;

import com.automobile.company.manager.model.enums.Brand;
import com.automobile.company.manager.model.enums.Model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomobileDTO {
    private String registrationNumber;
    private Integer modelYear;
    private Integer numberOfSeats;
    private Integer mileage;
    private Brand brand;
    private Model model;

}

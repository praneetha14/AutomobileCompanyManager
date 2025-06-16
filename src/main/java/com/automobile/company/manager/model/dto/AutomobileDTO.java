package com.automobile.company.manager.model.dto;

import com.automobile.company.manager.model.enums.Brand;
import com.automobile.company.manager.model.enums.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AutomobileDTO extends UpdateAutomobileDTO {
    private String registrationNumber;
    private UUID customerId;
    private Integer modelYear;
    private Integer numberOfSeats;
    private Brand brand;
    private Model model;

}

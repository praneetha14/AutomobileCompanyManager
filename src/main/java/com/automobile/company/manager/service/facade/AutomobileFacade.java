package com.automobile.company.manager.service.facade;

import com.automobile.company.manager.entity.AutomobileEntity;
import com.automobile.company.manager.model.dto.AutomobileDTO;
import com.automobile.company.manager.model.enums.Brand;
import com.automobile.company.manager.model.enums.Model;
import com.automobile.company.manager.service.AutomobileService;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor

public class AutomobileFacade {

    private final AutomobileService automobileService;

    public UUID createAutomobile(AutomobileDTO automobileDTO) {
        checkModel(automobileDTO.getModel(), automobileDTO.getBrand());
        AutomobileEntity automobileEntity = new AutomobileEntity();
        automobileEntity.setBrand(automobileDTO.getBrand());
        automobileEntity.setModel(automobileDTO.getModel());
        automobileEntity.setMileage(automobileDTO.getMileage());
        automobileEntity.setNumberOfSeats(automobileDTO.getNumberOfSeats());
        automobileEntity.setModelYear(automobileDTO.getModelYear());
        automobileEntity.setRegistrationNumber(automobileDTO.getRegistrationNumber());
        automobileEntity.setNumberOfSeats(automobileDTO.getNumberOfSeats());
        automobileEntity = automobileService.createAutomobile(automobileEntity);
        return automobileEntity.getId();
    }

    private void checkModel(Model model, Brand brand) {
        if (!Brand.brandModelMap.get(brand).contains(model)) {
            throw new RuntimeException("Invalid model: " + model);
        }
    }
}

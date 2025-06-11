package com.automobile.company.manager.service;

import com.automobile.company.manager.entity.AutomobileEntity;

import java.util.List;
import java.util.UUID;

public interface AutomobileService {
    AutomobileEntity createAutomobile(AutomobileEntity automobile);
    List<AutomobileEntity> getAllAutomobiles();
    AutomobileEntity getAutomobileById(UUID id);
    AutomobileEntity updateAutomobile(AutomobileEntity automobile);
    void deleteAutomobile(AutomobileEntity automobile);
}

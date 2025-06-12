package com.automobile.company.manager.service.impl;

import com.automobile.company.manager.entity.AutomobileEntity;
import com.automobile.company.manager.repository.AutomobileRepository;
import com.automobile.company.manager.service.AutomobileService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class AutomobileServiceImpl implements AutomobileService {

    private final AutomobileRepository automobileRepository;

    @Override
    public AutomobileEntity createAutomobile(AutomobileEntity automobile) {
        return automobileRepository.save(automobile);
    }

    @Override
    public List<AutomobileEntity> getAllAutomobiles() {
        return automobileRepository.findAll();
    }

    @Override
    public AutomobileEntity getAutomobileById(UUID id) { //Optional<AutomobileEntity>
        return automobileRepository.findById(id).orElse(null);
    }

    @Override
    public AutomobileEntity updateAutomobile(AutomobileEntity automobileEntity) {
        return automobileRepository.save(automobileEntity);
    }

    @Override
    public void deleteAutomobile(AutomobileEntity automobileEntity) {
        automobileRepository.delete(automobileEntity);
    }
}

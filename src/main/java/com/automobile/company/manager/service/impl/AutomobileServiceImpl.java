package com.automobile.company.manager.service.impl;

import com.automobile.company.manager.entity.AutomobileEntity;
import com.automobile.company.manager.repository.AutomobileRepository;
import com.automobile.company.manager.service.AutomobileService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AutomobileServiceImpl implements AutomobileService {

    private final AutomobileRepository automobileRepository;

    @Override
    public AutomobileEntity createAutomobile(AutomobileEntity automobile) {
        return automobileRepository.save(automobile);
    }
}

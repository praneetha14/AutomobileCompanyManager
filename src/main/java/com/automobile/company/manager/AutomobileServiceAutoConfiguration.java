package com.automobile.company.manager;

import com.automobile.company.manager.repository.AutomobileRepository;
import com.automobile.company.manager.service.AutomobileService;
import com.automobile.company.manager.service.facade.AutomobileFacade;
import com.automobile.company.manager.service.impl.AutomobileServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutomobileServiceAutoConfiguration {

    @Bean
    public AutomobileService automobileService(AutomobileRepository automobileRepository) {
        return new AutomobileServiceImpl(automobileRepository);
    }

    @Bean
    public AutomobileFacade automobileFacade(AutomobileService automobileService) {
        return new AutomobileFacade(automobileService);
    }
}

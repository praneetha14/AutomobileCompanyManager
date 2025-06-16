package com.automobile.company.manager;

import com.automobile.company.manager.repository.AutomobileRepository;
import com.automobile.company.manager.repository.CustomerRepository;
import com.automobile.company.manager.service.AutomobileService;
import com.automobile.company.manager.service.CustomerService;
import com.automobile.company.manager.service.facade.AutomobileFacade;
import com.automobile.company.manager.service.facade.CustomerFacade;
import com.automobile.company.manager.service.impl.AutomobileServiceImpl;
import com.automobile.company.manager.service.impl.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutomobileServiceAutoConfiguration {

    @Bean
    public AutomobileService automobileService(AutomobileRepository automobileRepository) {
        return new AutomobileServiceImpl(automobileRepository);
    }

    @Bean
    public AutomobileFacade automobileFacade(AutomobileService automobileService, CustomerService customerService) {
        return new AutomobileFacade(automobileService, customerService);
    }

    @Bean
    public CustomerService customerService(CustomerRepository customerRepository) {
        return new CustomerServiceImpl(customerRepository);
    }
    @Bean
    public CustomerFacade customerFacade(CustomerService customerService) {
        return new CustomerFacade(customerService);
    }
}

package com.automobile.company.manager.service.impl;

import com.automobile.company.manager.entity.CustomerEntity;
import com.automobile.company.manager.repository.CustomerRepository;
import com.automobile.company.manager.service.CustomerService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerEntity createCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public void deleteCustomerById(UUID customerId){
        customerRepository.deleteById(customerId);
    }
}

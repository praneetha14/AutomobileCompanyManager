package com.automobile.company.manager.service;

import com.automobile.company.manager.entity.CustomerEntity;
import com.automobile.company.manager.model.dto.CustomerDTO;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerEntity createCustomer(CustomerEntity customerEntity);
    List<CustomerEntity> getAllCustomers();
    CustomerEntity getCustomerById(UUID customerId);
    void deleteCustomerById(UUID customerId);
}

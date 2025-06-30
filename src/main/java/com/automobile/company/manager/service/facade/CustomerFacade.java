package com.automobile.company.manager.service.facade;

import com.automobile.company.manager.entity.CustomerEntity;
import com.automobile.company.manager.model.dto.CustomerDTO;
import com.automobile.company.manager.model.vo.AutomobileVO;
import com.automobile.company.manager.model.vo.CustomerVO;
import com.automobile.company.manager.service.CustomerService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class CustomerFacade {
    private final CustomerService customerService;

    public UUID createCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerName(customerDTO.getCustomerName());
        customerEntity.setCustomerPhone(customerDTO.getCustomerPhone());
        customerEntity.setCustomerEmail(customerDTO.getCustomerEmail());
        customerEntity.setCustomerAddress(customerDTO.getCustomerAddress());
        customerEntity = customerService.createCustomer(customerEntity);
        return customerEntity.getId();
    }

    public List<CustomerVO> getAllCustomers() {
        List<CustomerEntity> customerEntities = customerService.getAllCustomers();
        List<CustomerVO> customerVOList = new ArrayList<>();
        for (CustomerEntity customerEntity : customerEntities) {
            customerVOList.add(toVo(customerEntity));
        }
        return customerVOList;
    }

    public CustomerVO getCustomerById(UUID id) {
        CustomerEntity customerEntity = customerService.getCustomerById(id);
        if (customerEntity == null) {
            throw new RuntimeException("Customer not found");
        } else {
            return toVo(customerEntity);
        }
    }

    public void deleteCustomerById(UUID id) {
        if(customerService.getCustomerById(id) == null) {
            throw new RuntimeException("Customer not found");
        }
        customerService.deleteCustomerById(id);
    }

    private CustomerVO toVo(CustomerEntity customerEntity) {
        return new CustomerVO(customerEntity.getId(), customerEntity.getCustomerName(), customerEntity.getCustomerPhone(),
                customerEntity.getCustomerEmail(),customerEntity.getCustomerAddress());
    }
}

package com.automobile.company.manager.service.facade;

import com.automobile.company.manager.entity.AutomobileEntity;
import com.automobile.company.manager.entity.CustomerEntity;
import com.automobile.company.manager.model.dto.AutomobileDTO;
import com.automobile.company.manager.model.dto.UpdateAutomobileDTO;
import com.automobile.company.manager.model.enums.Brand;
import com.automobile.company.manager.model.enums.Model;
import com.automobile.company.manager.model.vo.AutomobileVO;
import com.automobile.company.manager.model.vo.CustomerVO;
import com.automobile.company.manager.service.AutomobileService;
import com.automobile.company.manager.service.CustomerService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class AutomobileFacade {

    private final AutomobileService automobileService;

    private final CustomerService customerService;

    public UUID createAutomobile(AutomobileDTO automobileDTO) {
        checkModel(automobileDTO.getModel(), automobileDTO.getBrand());
        CustomerEntity customer = customerService.getCustomerById(automobileDTO.getCustomerId());
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }
        AutomobileEntity automobileEntity = new AutomobileEntity();
        automobileEntity.setBrand(automobileDTO.getBrand());
        automobileEntity.setModel(automobileDTO.getModel());
        automobileEntity.setMileage(automobileDTO.getMileage());
        automobileEntity.setNumberOfSeats(automobileDTO.getNumberOfSeats());
        automobileEntity.setModelYear(automobileDTO.getModelYear());
        automobileEntity.setRegistrationNumber(automobileDTO.getRegistrationNumber());
        automobileEntity.setCustomerEntity(customer);
        automobileEntity = automobileService.createAutomobile(automobileEntity);
        return automobileEntity.getId();
    }

    private void checkModel(Model model, Brand brand) {
        if (!Brand.brandModelMap.get(brand).contains(model)) {
            throw new RuntimeException("Invalid model: " + model);
        }
    }

    public List<AutomobileVO> getAllAutomobiles() {
        List<AutomobileEntity> automobileEntities = automobileService.getAllAutomobiles();
        List<AutomobileVO> automobileVOList = new ArrayList<>();
        for (AutomobileEntity automobileEntity : automobileEntities) {
            automobileVOList.add(toVO(automobileEntity));
        }
        return automobileVOList;
    }

    public AutomobileVO getAutomobileById(UUID id) {
        AutomobileEntity automobileEntity = automobileService.getAutomobileById(id);
        if (automobileEntity == null) {
            throw new RuntimeException("Automobile with id " + id + " not found");
        } else {
            return toVO(automobileEntity);
        }
    }

    public AutomobileVO updateAutomobile(UUID id, UpdateAutomobileDTO updateAutomobileDTO) {
        AutomobileEntity automobileEntity = automobileService.getAutomobileById(id);
        if (automobileEntity == null) {
            throw new RuntimeException("Automobile does not exist with id: " + id);
        }
        automobileEntity.setMileage(updateAutomobileDTO.getMileage());
        automobileEntity = automobileService.updateAutomobile(automobileEntity);
        return toVO(automobileEntity);
    }

    public void deleteAutomobile(UUID id) {
        AutomobileEntity automobileEntity = automobileService.getAutomobileById(id);
        if (automobileEntity == null) {
            throw new RuntimeException("Automobile does not exist with id: " + id);
        }
        automobileService.deleteAutomobile(automobileEntity);
    }

    public AutomobileVO updateAutomobileCustomer(UUID id, UUID customerId){
        AutomobileEntity automobileEntity = automobileService.getAutomobileById(id);
        CustomerEntity customerEntity = customerService.getCustomerById(customerId);
        if (automobileEntity == null) {
            throw new RuntimeException("Automobile does not exist with id: " + id);
        }
        if(customerEntity == null){
            throw new RuntimeException("Customer does not exist with id: " + id);
        }
        automobileEntity.setCustomerEntity(customerEntity);
        automobileService.updateAutomobile(automobileEntity);
        return toVO(automobileEntity);
    }

    private AutomobileVO toVO(AutomobileEntity automobileEntity) {
        return new AutomobileVO(automobileEntity.getId(), automobileEntity.getRegistrationNumber(),
                automobileEntity.getModelYear(), automobileEntity.getNumberOfSeats(), automobileEntity.getMileage(),
                automobileEntity.getBrand(), automobileEntity.getModel(),toCustomerVO(automobileEntity.getCustomerEntity()));
    }

    private CustomerVO toCustomerVO(CustomerEntity customerEntity) {
        return new CustomerVO(customerEntity.getId(),customerEntity.getCustomerName(), customerEntity.getCustomerPhone(),
                customerEntity.getCustomerEmail(), customerEntity.getCustomerAddress());
    }

}


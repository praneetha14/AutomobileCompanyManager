package com.automobile.company.manager;

import com.automobile.company.manager.model.dto.CustomerDTO;
import com.automobile.company.manager.model.vo.CustomerVO;
import com.automobile.company.manager.service.facade.CustomerFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class CustomerFacadeTest extends AbstractTest{
    @Autowired
    private CustomerFacade customerFacade;

    @Test
    void createCustomerByIdSuccessTest() {
        CustomerDTO customerDTO = createCustomerDTO();
        UUID customerId = customerFacade.createCustomer(customerDTO);
        assertNotNull(customerId);
    }

    @Test
    void getAllCustomersSuccessTest() {
        CustomerDTO customerDTO = createCustomerDTO();
        customerFacade.createCustomer(customerDTO);
        List<CustomerVO> customerVOList = customerFacade.getAllCustomers();
        assertNotNull(customerVOList);
        assertEquals( 1, customerVOList.size());
    }

    @Test
    void getAllCustomersWithoutAnyCustomerSuccessTest() {
        List<CustomerVO> customerVOList = customerFacade.getAllCustomers();
        assertEquals( 0, customerVOList.size());
    }

    @Test
    void getCustomerByIdSuccessTest() {
        CustomerDTO customerDTO = createCustomerDTO();
        UUID id = customerFacade.createCustomer(customerDTO);
        CustomerVO customerVO = customerFacade.getCustomerById(id);
        assertNotNull(customerVO);
        assertEquals(id, customerVO.getId());
    }

    @Test
    void getCustomerByIdFailureTest() {
        UUID id = UUID.randomUUID();
        Throwable exception = assertThrows(RuntimeException.class, () -> customerFacade.getCustomerById(id));
        assertNotNull(exception);
        assertEquals("Customer not found", exception.getMessage());
    }

    @Test
    void deleteCustomerByIdSuccessTest() {
        CustomerDTO customerDTO = createCustomerDTO();
        UUID id = customerFacade.createCustomer(customerDTO);
        customerFacade.deleteCustomerById(id);
        Throwable exception = assertThrows(RuntimeException.class, () -> customerFacade.deleteCustomerById(id));
        assertNotNull(exception);
        assertEquals("Customer does not exist", exception.getMessage());
    }

    @Test
    void deleteCustomerByIdFailureTest() {
        UUID id = UUID.randomUUID();
        Throwable exception = assertThrows(RuntimeException.class, () -> customerFacade.deleteCustomerById(id));
        assertNotNull(exception);
        assertEquals("Customer does not exist", exception.getMessage());
    }

    private CustomerDTO createCustomerDTO() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerAddress("Gurugram");
        customerDTO.setCustomerName("Praneetha");
        customerDTO.setCustomerEmail("praneetha@gmail.com");
        return customerDTO;
    }
}

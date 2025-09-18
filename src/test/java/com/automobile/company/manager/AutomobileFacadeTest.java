package com.automobile.company.manager;

import com.automobile.company.manager.model.dto.AutomobileDTO;
import com.automobile.company.manager.model.dto.CustomerDTO;
import com.automobile.company.manager.model.enums.Brand;
import com.automobile.company.manager.model.vo.AutomobileVO;
import com.automobile.company.manager.service.facade.AutomobileFacade;
import com.automobile.company.manager.service.facade.CustomerFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

//this test class contains test cases for code in Automobile Facade
public class AutomobileFacadeTest extends AbstractTest {
    private static final String DELETE_AUTOMOBILE_ERROR_MESSAGE = "Automobile does not exist with id: ";
    @Autowired
    private AutomobileFacade automobileFacade;
    @Autowired
    private CustomerFacade customerFacade;

    @Test
    void createAutomobileFacadeSuccessTest() {
        AutomobileDTO automobileDTO = createAutomobileDTO();
        CustomerDTO customerDTO = createCustomerDTO();
        UUID customerId = customerFacade.createCustomer(customerDTO);
        automobileDTO.setCustomerId(customerId);
        UUID id = automobileFacade.createAutomobile(automobileDTO);
        assertNotNull(id);
    }

    @Test
    void createAutomobileWithInvalidCustomerIDFailureTest() {
        AutomobileDTO automobileDTO = createAutomobileDTO();
        UUID invalidCustomerID = UUID.randomUUID();
        automobileDTO.setCustomerId(invalidCustomerID);
        Throwable exception = assertThrows(RuntimeException.class, () -> automobileFacade.createAutomobile(automobileDTO));
        assertNotNull(exception);
        assertEquals("Customer not found", exception.getMessage());
    }

    @Test
    void createAutomobileWithInvalidBrandFailureTest() {
        AutomobileDTO automobileDTO = createAutomobileDTO();
        automobileDTO.setBrand(Brand.MARUTHI);
        CustomerDTO customerDTO = createCustomerDTO();
        UUID customerId = customerFacade.createCustomer(customerDTO);
        automobileDTO.setCustomerId(customerId);
        Throwable exception = assertThrows(RuntimeException.class,
                () -> automobileFacade.createAutomobile(automobileDTO));
        assertNotNull(exception);
        assertEquals("Invalid model: " + automobileDTO.getModel(), exception.getMessage());
    }

    @Test
    void getAllAutomobilesSuccessTest() {
        AutomobileDTO automobileDTO = createAutomobileDTO();
        CustomerDTO customerDTO = createCustomerDTO();
        UUID customerId = customerFacade.createCustomer(customerDTO);
        automobileDTO.setCustomerId(customerId);
        automobileFacade.createAutomobile(automobileDTO);
        List<AutomobileVO> automobileVOList = automobileFacade.getAllAutomobiles();
        assertNotNull(automobileVOList);
        assertEquals(1, automobileVOList.size());
    }

    @Test
    void getAllAutomobilesWithoutAnyAutomobileSuccessTest() {
        List<AutomobileVO> automobileVOList = automobileFacade.getAllAutomobiles();
        assertEquals(0, automobileVOList.size());
    }

    @Test
    void getAutomobileByIdSuccessTest() {
        AutomobileDTO automobileDTO = createAutomobileDTO();
        CustomerDTO customerDTO = createCustomerDTO();
        UUID customerId = customerFacade.createCustomer(customerDTO);
        automobileDTO.setCustomerId(customerId);
        UUID id = automobileFacade.createAutomobile(automobileDTO);
        AutomobileVO automobileVO = automobileFacade.getAutomobileById(id);
        assertNotNull(automobileVO);
        assertEquals(id, automobileVO.getId());
    }

    @Test
    void getAutomobileByIdFailureTest() {
        UUID id = UUID.randomUUID();
        Throwable exception = assertThrows(RuntimeException.class, () -> automobileFacade.getAutomobileById(id));
        assertNotNull(exception);
        assertEquals("Automobile with id " + id + " not found", exception.getMessage());
    }

    @Test
    void updateAutomobileByIdSuccessTest() {
        AutomobileDTO automobileDTO = createAutomobileDTO();
        CustomerDTO customerDTO = createCustomerDTO();
        UUID customerId = customerFacade.createCustomer(customerDTO);
        automobileDTO.setCustomerId(customerId);
        UUID id = automobileFacade.createAutomobile(automobileDTO);
        automobileDTO.setMileage(17);
        automobileFacade.updateAutomobile(id, automobileDTO);
        assertNotNull(id);
    }

    @Test
    void updateAutomobileByIdFailureTest() {
        UUID id = UUID.randomUUID();
        Throwable exception = assertThrows(RuntimeException.class, () -> automobileFacade.getAutomobileById(id));
        assertNotNull(exception);
        assertEquals("Automobile with id " + id + " not found", exception.getMessage());
    }

    @Test
    void deleteAutomobileByIdSuccessTest() {
        AutomobileDTO automobileDTO = createAutomobileDTO();
        CustomerDTO customerDTO = createCustomerDTO();
        UUID customerId = customerFacade.createCustomer(customerDTO);
        automobileDTO.setCustomerId(customerId);
        UUID id = automobileFacade.createAutomobile(automobileDTO);
        automobileFacade.deleteAutomobile(id);
        Throwable exception = assertThrows(RuntimeException.class, () -> automobileFacade.deleteAutomobile(id));
        assertNotNull(id);
        assertNotNull(exception);
        assertEquals(DELETE_AUTOMOBILE_ERROR_MESSAGE + id, exception.getMessage());
    }

    @Test
    void updateAutomobileCustomerByIdSuccessTest() {
        AutomobileDTO automobileDTO = createAutomobileDTO();
        CustomerDTO customerDTO = createCustomerDTO();
        UUID customerId = customerFacade.createCustomer(customerDTO);
        automobileDTO.setCustomerId(customerId);
        UUID id = automobileFacade.createAutomobile(automobileDTO);
        automobileDTO.setCustomerId(customerId);
        automobileFacade.updateAutomobile(id, automobileDTO);
        assertNotNull(id);
    }

    @Test
    void updateAutomobileCustomerByIdFailureTest() {
        CustomerDTO customerDTO = createCustomerDTO();
        UUID customerId = customerFacade.createCustomer(customerDTO);
        UUID id = UUID.randomUUID();
        Throwable exception = assertThrows(RuntimeException.class, () -> automobileFacade.updateAutomobileCustomer(id, customerId));
        assertNotNull(exception);
        assertEquals("Automobile does not exist with id: " + id, exception.getMessage());
    }

    @Test
    void updateAutomobileCustomerByCustomerIdFailureTest() {
        AutomobileDTO automobileDTO = createAutomobileDTO();
        CustomerDTO customerDTO = createCustomerDTO();
        UUID cid = customerFacade.createCustomer(customerDTO);
        automobileDTO.setCustomerId(cid);
        UUID id = automobileFacade.createAutomobile(automobileDTO);
        UUID customerId = UUID.randomUUID();
        Throwable exception = assertThrows(RuntimeException.class, () -> automobileFacade.updateAutomobileCustomer(id, customerId));
        assertNotNull(exception);
        assertEquals("Customer does not exist with id: " + customerId, exception.getMessage());
    }

    @Test
    void deleteAutomobileByIdFailureTest() {
        UUID id = UUID.randomUUID();
        Throwable exception = assertThrows(RuntimeException.class, () -> automobileFacade.deleteAutomobile(id));
        assertNotNull(exception);
        assertEquals(DELETE_AUTOMOBILE_ERROR_MESSAGE + id, exception.getMessage());
    }

    private CustomerDTO createCustomerDTO() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerAddress("Gurugram");
        customerDTO.setCustomerName("Praneetha");
        customerDTO.setCustomerEmail("praneetha@gmail.com");
        return customerDTO;
    }
}

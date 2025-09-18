package com.automobile.company.manager.web;

import com.automobile.company.manager.AbstractTest;
import com.automobile.company.manager.AutomobileCompanyManagerApplication;
import com.automobile.company.manager.model.dto.AutomobileDTO;
import com.automobile.company.manager.rest.v1.AutomobileController;
import com.automobile.company.manager.service.facade.AutomobileFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AutomobileController.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AutomobileController.class, AbstractTest.TestConfiguration.class})
public class AutomobileControllerTest {
    private static final String AUTOMOBILE_URL = "api/v1/automobiles";
    private static final String CREATE_URL = "/create";
    @MockBean
    private AutomobileFacade automobileFacade;
    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createAutomobileSuccessTest() throws Exception {
        AutomobileDTO automobileDTO = new AutomobileDTO();
        when(automobileFacade.createAutomobile(automobileDTO)).thenReturn(UUID.randomUUID());
        mockMvc.perform(
                post(AUTOMOBILE_URL + CREATE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(automobileDTO))
        ).andExpect(status().isCreated());
    }
}

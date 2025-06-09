package com.automobile.company.manager.rest.v1;

import com.automobile.company.manager.model.dto.AutomobileDTO;
import com.automobile.company.manager.service.facade.AutomobileFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/automobiles")
@RequiredArgsConstructor

public class AutomobileController {

    private final AutomobileFacade automobileFacade;

    @PostMapping("/create")
    public ResponseEntity<UUID> createAutomobile(@RequestBody AutomobileDTO automobileDTO) {
        return new ResponseEntity<>(automobileFacade.createAutomobile(automobileDTO), HttpStatus.CREATED);
    }


}

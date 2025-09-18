package com.automobile.company.manager.rest.v1;

import com.automobile.company.manager.model.dto.EmployeeDTO;
import com.automobile.company.manager.service.facade.EmployeeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeFacade employeeFacade;

    @PostMapping("/create")
    public ResponseEntity<UUID> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeFacade.createEmployee(employeeDTO), HttpStatus.CREATED);
    }
}

package com.automobile.company.manager.rest.v1;

import com.automobile.company.manager.model.dto.CustomerDTO;
import com.automobile.company.manager.model.vo.CustomerVO;
import com.automobile.company.manager.service.facade.CustomerFacade;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerFacade customerFacade;

    @PostMapping("/create")
    public ResponseEntity<UUID> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerFacade.createCustomer(customerDTO), HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<List<CustomerVO>> getAllCustomers() {
        return ResponseEntity.ok(customerFacade.getAllCustomers());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CustomerVO> getCustomerById(@PathVariable UUID id) {
        return ResponseEntity.ok(customerFacade.getCustomerById(id));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable UUID id) {
        customerFacade.deleteCustomerById(id);
    }

}

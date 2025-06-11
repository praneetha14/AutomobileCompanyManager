package com.automobile.company.manager.rest.v1;

import com.automobile.company.manager.model.dto.AutomobileDTO;
import com.automobile.company.manager.model.dto.UpdateAutomobileDTO;
import com.automobile.company.manager.model.vo.AutomobileVO;
import com.automobile.company.manager.service.facade.AutomobileFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/find")
    public ResponseEntity<List<AutomobileVO>> getAllAutomobiles() {
        return ResponseEntity.ok(automobileFacade.getAllAutomobiles());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AutomobileVO> getAutomobileById(@PathVariable UUID id) {
        return ResponseEntity.ok(automobileFacade.getAutomobileById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AutomobileVO> updateAutomobile(@PathVariable UUID id, @RequestBody UpdateAutomobileDTO updateAutomobileDTO) {
        return ResponseEntity.ok(automobileFacade.updateAutomobile(id, updateAutomobileDTO));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAutomobile(@PathVariable UUID id) {
        automobileFacade.deleteAutomobile(id);
    }
}

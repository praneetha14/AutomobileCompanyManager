package com.automobile.company.manager.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CustomerDTO {
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
}

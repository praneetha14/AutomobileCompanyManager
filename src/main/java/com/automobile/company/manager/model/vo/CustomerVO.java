package com.automobile.company.manager.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CustomerVO {
    private UUID id;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
}

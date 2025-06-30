package com.automobile.company.manager.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class UserLoginDTO {
    private String userEmail;
    private String userPassword;
}

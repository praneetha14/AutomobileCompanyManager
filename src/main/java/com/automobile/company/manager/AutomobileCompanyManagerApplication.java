package com.automobile.company.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.automobile.company.manager.entity"})
public class AutomobileCompanyManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomobileCompanyManagerApplication.class, args);
	}

}

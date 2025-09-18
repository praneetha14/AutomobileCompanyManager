package com.automobile.company.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeRepository, UUID> {
}

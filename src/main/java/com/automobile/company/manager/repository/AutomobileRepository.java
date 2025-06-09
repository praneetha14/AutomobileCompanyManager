package com.automobile.company.manager.repository;

import com.automobile.company.manager.entity.AutomobileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutomobileRepository extends JpaRepository<AutomobileEntity, UUID> {
}

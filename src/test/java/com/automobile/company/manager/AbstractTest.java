package com.automobile.company.manager;

import com.automobile.company.manager.model.dto.AutomobileDTO;
import com.automobile.company.manager.model.enums.Brand;
import com.automobile.company.manager.model.enums.Model;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Table;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = {AutomobileCompanyManagerApplication.class, AutomobileServiceAutoConfiguration.class,
        AbstractTest.TestConfiguration.class})
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@EnableAutoConfiguration
public abstract class AbstractTest {

    private List<String> tables;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    public void setup() {
        if (tables == null || tables.isEmpty()) {
            tables = new ArrayList<>();
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getMetamodel().getManagedTypes()
                    .stream()
                    .filter(it -> it.getJavaType().isAnnotationPresent(Table.class))
                    .map(type -> type.getJavaType().getAnnotation(Table.class).name())
                    .forEach(tables::add);
        }
    }

    @AfterEach
    public void cleanup() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();
                tables.forEach(table -> entityManager.createNativeQuery("TRUNCATE TABLE " + table).executeUpdate());
                entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
            }
        }
    }

    protected AutomobileDTO createAutomobileDTO() {
        AutomobileDTO automobileDTO = new AutomobileDTO();
        automobileDTO.setBrand(Brand.AUDI);
        automobileDTO.setModel(Model.A5);
        automobileDTO.setModelYear(2020);
        automobileDTO.setRegistrationNumber("AP12ER1234");
        automobileDTO.setMileage(22);
        automobileDTO.setNumberOfSeats(5);
        return automobileDTO;
    }

    @org.springframework.boot.test.context.TestConfiguration
    public static class TestConfiguration {

    }
}

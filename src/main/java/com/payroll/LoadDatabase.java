package com.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository){
        return args -> {
            employeeRepository.save(new Employee("Abiud", "Thomas", "Spring"));
            employeeRepository.save(new Employee("Faraja", "Sabaya", "Fluter"));
            employeeRepository.findAll().forEach(employee -> log.info("Preloading " + employee));

            orderRepository.save(new Order("MacBookPro", Status.COMPLETED));
            orderRepository.save(new Order("Iphone", Status.IN_PROGRESS));
            orderRepository.findAll().forEach(order -> log.info("Preloading " + order));
        };
    }

}

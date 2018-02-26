package com.training.jpa.firstspringdataapp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class RunAtStart {
    private final EmployeeRepository employeeRepository;
    private final EmployeeGenerator employeeGenerator;
    private final Logger logger = Logger.getLogger(RunAtStart.class);

    @Autowired
    public RunAtStart(EmployeeRepository employeeRepository, EmployeeGenerator employeeGenerator) {
        this.employeeRepository = employeeRepository;
        this.employeeGenerator = employeeGenerator;
    }

    @PostConstruct
    public void runAtStart() {
        for (int i = 0; i < 100; i++) {
            employeeRepository.save(employeeGenerator.generate());
        }
        List<Employee> allUnsorted = employeeRepository.findAll();
        printAll(allUnsorted);

        List<Employee> sortedByFirstName = employeeRepository.findAll(new Sort
                        (new Sort.Order(Sort.Direction.ASC, "firstName"),
                        (new Sort.Order(Sort.Direction.ASC, "lastName")
                        )));
        logger.info("SORTED BY FIRST NAME");

        Page<Employee> pages = employeeRepository.findAll(new PageRequest(2, 10));
        logger.info("TOTAL NUMBER OF EMPLOYEES: " + pages.getTotalElements() );
        logger.info("TOTAL NUMBER OF PAGES: " + pages.getTotalPages() );
        System.out.println(pages.getContent());


    }

    private void printAll(List<Employee> allUnsorted) {
        allUnsorted.forEach(logger::info);

    }

}

package com.tramp.springmvc.company;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.Bidi;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeGenerator {
    private static final String FIRST_NAMES_FILE_PATH = "firstNames";
    private static final double SALARY_BASE = 1_000.0;
    private static final double SALARY_SPREAD = 10_000.0;
    private final FileLinesLoader fileLinesLoader;
    private List<String> firstNames;
    private List<String> lastNames;
    private final Random random = new Random();

    EmployeeGenerator(FileLinesLoader fileLinesLoader) {
        this.fileLinesLoader = fileLinesLoader;
    }

    List<Employee> generate(int numberOfEmployees) {
        return Stream.generate(this::generate).limit(numberOfEmployees).collect(Collectors.toList());
    }

    private Employee generate() {
        return new Employee(getRandomFirstName(), getRandomLastName(), getRandomSalary());
    }

    private String getRandomFirstName() {
        return getRandom(getFirstNames());
    }

    private String getRandomLastName() {
        return getRandom(getLastNames());
    }

    private BigDecimal getRandomSalary() {
        return new BigDecimal(SALARY_BASE + Math.random() * SALARY_SPREAD);
    }

    private String getRandom(List<String> elements) {
        return elements.get(random.nextInt(elements.size()));
    }

    private List<String> getFirstNames() {
        if (firstNames == null) {
            firstNames = fileLinesLoader.loadLines(FIRST_NAMES_FILE_PATH);
        }
        return lastNames;
    }

    private List<String> getLastNames() {
        if (firstNames == null) {
            firstNames = fileLinesLoader.loadLines("lastNames");
        }
        return lastNames;
    }


}


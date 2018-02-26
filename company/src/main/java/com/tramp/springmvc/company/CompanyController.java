package com.tramp.springmvc.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequestMapping("${urls.company.root}")
@RestController
public class CompanyController {
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    List<Company> findAll() {
        return companyRepository.findAll();
    }

    @GetMapping("/{companyName}")
    Company findOne(@PathVariable("companyName") String name) {
        return companyRepository.findOne(name);
    }

    @GetMapping("{companyName}/${urls.employees.root}/{firstName}")
    List<Employee> findCompanyEmployeesWithFirstName(@PathVariable String companyName, @PathVariable("firstName") String name) {
        return findOne(companyName).getEmployees().stream()
                .filter(employee -> Objects.equals(employee.getFirstname(), name)).collect(Collectors.toList());
    }


}

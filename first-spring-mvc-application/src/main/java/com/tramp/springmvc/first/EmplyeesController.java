package com.tramp.springmvc.first;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("employees")
@RestController
public class EmplyeesController {
    @RequestMapping(value = "getEmployees", method = {RequestMethod.POST, RequestMethod.GET)
    public @ResponseBody List<Employee>getEmployees(){
        List<Employee>result = new ArrayList<>();
        result.add(new Employee("Janek","Nowak", new BigDecimal("3426.153")));
        result.add(new Employee("Arek","Kowalewski", new BigDecimal("3342.152")));
        result.add(new Employee("Pioter","Nul", new BigDecimal("3216.193")));
        return result;
    }
    @RequestMapping(value = "findAny", method = RequestMethod.GET)
    public Employee findAny(){
        return new Employee("Janek","Nowak", new BigDecimal("3426.153"));
    }
}

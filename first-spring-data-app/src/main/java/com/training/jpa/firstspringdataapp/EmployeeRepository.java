package com.training.jpa.firstspringdataapp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAll(Sort sort);

    Page<Employee> findAll(PageRequest pageRequest);

    List<Employee> findAll();

    List<Employee> EmployeeFindAllBetweenSomeValues(BigDecimal from, BigDecimal to);

    @Query(value = "select e from Employee e where e.salary = (select max(em.salary)from Employee em)")
    List<Employee> findGuyWithHighestSalary();

    @Query(value = "select * from Employee where salary =(select max(salary) from employee limit 1)", nativeQuery = true)
    Employee findOnlyOneGuyWithHighestSalary();

    @Query(value = "select * from Employee where salary between :from and :to", nativeQuery = true)
    Employee findNativelyWithSalaryBetween(@Param("from")BigDecimal from, @Param("to")BigDecimal to);
}

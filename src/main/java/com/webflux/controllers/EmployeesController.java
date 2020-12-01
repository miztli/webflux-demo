package com.webflux.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.webflux.models.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeesController
{
    private Map<String, Employee> employeeRepository =  new HashMap<>();

    public EmployeesController()
    {
        init();
    }

    @GetMapping
    public Map<String, Employee> findAll() {
        return employeeRepository;
    }

    @GetMapping(value = "/{id}")
    public Employee findById(@PathVariable final String id) {
        return Optional.ofNullable(employeeRepository.get(id))
            .orElseThrow(() -> new NoSuchElementException("Employee not found for id: " + id));
    }

    private void init() {
        employeeRepository.put("1", new Employee("Miztli", 30));
        employeeRepository.put("2", new Employee("Eduardo", 32));
    }
}

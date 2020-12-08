package com.webflux.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.webflux.models.Employee;
import com.webflux.service.IEmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService
{
    private Map<String, Employee> employeeRepository = new HashMap<>();

    public EmployeeServiceImpl()
    {
        init();
    }

    @Override
    public Collection<Employee> findAll()
    {
        return employeeRepository.values();
    }

    @Override
    public Employee findById(String id)
    {
        return employeeRepository.get(id);
    }

    private void init()
    {
        for (int i = 0; i < 50; i++)
        {
            employeeRepository.put(String.valueOf(i), new Employee("employee " + i, i));
        }
    }
}

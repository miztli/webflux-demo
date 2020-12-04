package com.webflux.service;

import java.util.Collection;

import com.webflux.models.Employee;

public interface IEmployeeService
{
    Collection<Employee> findAll();

    Employee findById(final String id);
}

package com.webflux.controllers;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;
import javax.annotation.Resource;

import com.webflux.models.Employee;
import com.webflux.service.IEmployeeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeesController
{
    @Resource
    private IEmployeeService iEmployeeService;

    @GetMapping
    public Collection<Employee> findAll()
    {
        return iEmployeeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Employee findById(@PathVariable final String id)
    {
        return Optional.ofNullable(iEmployeeService.findById(id))
            .orElseThrow(() -> new NoSuchElementException("Employee not found for id: " + id));
    }

    @GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Employee> findAllFlux()
    {
        System.out.println("Calling thread: " + Thread.currentThread().getName());
        return Flux.fromIterable(iEmployeeService.findAll())
            //.delayElements(Duration.ofSeconds(2))
            .log()
            .limitRate(3);
    }

    @GetMapping(value = "/flux/{id}")
    public Mono<Employee> findByIdMono(@PathVariable final String id)
    {
        return Optional.ofNullable(iEmployeeService.findById(id))
            .map(Mono::just)
            .orElseThrow(() -> new NoSuchElementException("Employee not found for id: " + id));
    }
}

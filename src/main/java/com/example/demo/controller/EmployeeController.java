package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Employee employee) {
        employeeService.create(employee);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> findById(@PathVariable("id") Integer id) {
        Employee employeeMono = employeeService.findById(id);
        HttpStatus httpStatus = employeeMono != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(employeeMono, httpStatus);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public List<Employee> findByName(@PathVariable("name") String name) {
        return employeeService.findByName(name);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees= employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        employeeService.delete(id);
    }
}

package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee create(Employee employee);
    Employee findById(Integer id);
    List<Employee> findByName(String name);
    List<Employee> findAll();
    Employee update(Employee employee);
    void delete(Integer id);
}

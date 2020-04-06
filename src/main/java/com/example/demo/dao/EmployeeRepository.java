package com.example.demo.dao;

import com.example.demo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

    @Query("{'name': ?0}")
    List<Employee> findByName(String name);
}

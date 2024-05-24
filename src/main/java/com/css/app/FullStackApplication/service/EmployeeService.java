package com.css.app.FullStackApplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.css.app.FullStackApplication.model.Employee;

@Service
public class EmployeeService {
	private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

}

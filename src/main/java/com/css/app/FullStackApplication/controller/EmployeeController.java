package com.css.app.FullStackApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.css.app.FullStackApplication.model.Employee;
import com.css.app.FullStackApplication.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired EmployeeService employeeService;
	@PostMapping
	public void saveEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
}

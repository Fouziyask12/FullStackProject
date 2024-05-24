package com.css.app.FullStackApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.FullStackApplication.model.Employee;
import com.css.app.FullStackApplication.model.Vendor;
import com.css.app.FullStackApplication.repository.EmailReposiitory;
import com.css.app.FullStackApplication.repository.EmployeeRepo;
import com.css.app.FullStackApplication.repository.VendorRepo;

@Service
public class AdminService {
	@Autowired EmailService emailService;
	@Autowired EmployeeRepo employeeRepo;
	@Autowired VendorRepo vendorRepo;
	
	public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Vendor createVendor(Vendor vendor) {
        return vendorRepo.save(vendor);
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Iterable<Vendor> getAllVendors() {
        return vendorRepo.findAll();
    }

    public void sendEmail(String employeeEmail, String vendorEmail) {
        Employee employee = employeeRepo.findById(employeeEmail).orElseThrow(() -> new RuntimeException("Employee not found"));
        Vendor vendor = vendorRepo.findById(vendorEmail).orElseThrow(() -> new RuntimeException("Vendor not found"));
        
        emailService.sendEmail(employee, vendor);
    }

}

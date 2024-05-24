package com.css.app.FullStackApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.css.app.FullStackApplication.model.Employee;
import com.css.app.FullStackApplication.model.Vendor;
import com.css.app.FullStackApplication.service.AdminService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired AdminService adminService;
	@PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return adminService.createEmployee(employee);
    }

    @PostMapping("/vendors")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return adminService.createVendor(vendor);
    }

    
    @GetMapping("/employees")
    public Iterable<Employee> getAllEmployees() {
        return adminService.getAllEmployees();
    }
    @GetMapping("/vendors")
    public Iterable<Vendor> getAllVendors() {
        return adminService.getAllVendors();
    }
    
    
    @PostMapping("/sendemail")
    public void sendEmail(@RequestParam String employeeEmail, @RequestParam String vendorEmail) {
        adminService.sendEmail(employeeEmail, vendorEmail);
    }



}

package com.css.app.FullStackApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.css.app.FullStackApplication.model.Vendor;
import com.css.app.FullStackApplication.service.VendorService;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin("*")
public class VendorController {
	@Autowired VendorService vendorService;
	
    @PostMapping
    public void saveVendors(@RequestBody Vendor vendor )
    {
    	vendorService.addVendor(vendor);
    }
	public List<Vendor> getAllVendors()
	{
		return vendorService.getAllVendors();
	}

}

package com.css.app.FullStackApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.css.app.FullStackApplication.model.EmailSend;
import com.css.app.FullStackApplication.service.EmailService;
import com.css.app.FullStackApplication.service.VendorService;

@RestController
@RequestMapping("/api/emailsend")
@CrossOrigin("*")
public class EmailController {

	@Autowired
	EmailService emailService;
	@Autowired VendorService vendorService;
	
	@PostMapping
	public void sendEmail(@RequestBody List<String> vendorEmail )
	{
		emailService.emailSend(vendorEmail, vendorService.getAllVendors());
	}
	@GetMapping
	public List<EmailSend> getAllEmailSend()
	{
		return emailService.getAllEmails();
	}
}

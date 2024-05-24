package com.css.app.FullStackApplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.css.app.FullStackApplication.model.EmailSend;
import com.css.app.FullStackApplication.model.Employee;
import com.css.app.FullStackApplication.model.Vendor;

@Service
public class EmailService {
	public final List<EmailSend> emailSends =new ArrayList<>();
	
	public void emailSend(List<String> vendorEmail, List<Vendor> vendors)
	{
		for(String email : vendorEmail) {
			Vendor vendor = vendors.stream().filter(v -> v.getEmail()
					.equals(email)).findFirst().orElse(null);
			if(vendor != null) {
				String message = "Sending payments to vendor " + vendor.getName()+ "at upi" + vendor.getUpi();
				System.out.println("Email sent to" +vendor.getEmail()+ message);
				emailSends.add(new EmailSend(null, vendor.getEmail(), message));
				
			}
		}
	}
	public List<EmailSend> getAllEmails(){
		return emailSends;
		
	}
	public void sendEmail(Employee employee, Vendor vendor) {
		System.out.println("Sending email to " + employee.getEmail() + " about " + vendor.getName() + " at " + vendor.getUpi());
		
	}

}

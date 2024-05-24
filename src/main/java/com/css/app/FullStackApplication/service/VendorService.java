package com.css.app.FullStackApplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.css.app.FullStackApplication.model.Vendor;

@Service
public class VendorService {
	private final List<Vendor> vendors = new ArrayList<>();

    public void addVendor(Vendor vendor) {
        vendors.add(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendors;
    }
}

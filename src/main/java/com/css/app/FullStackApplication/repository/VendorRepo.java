package com.css.app.FullStackApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.css.app.FullStackApplication.model.Vendor;
@Repository
public interface VendorRepo extends CrudRepository<Vendor, String> {

}

package com.css.app.FullStackApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.css.app.FullStackApplication.model.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, String> {

}

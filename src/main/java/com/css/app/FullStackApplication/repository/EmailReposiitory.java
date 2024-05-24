package com.css.app.FullStackApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.css.app.FullStackApplication.model.EmailSend;

@Repository
public interface EmailReposiitory extends CrudRepository<EmailSend, Long >{

}

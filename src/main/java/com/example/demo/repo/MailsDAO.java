package com.example.demo.repo;

import com.example.demo.models.Mails;
import org.springframework.data.repository.CrudRepository;

public interface MailsDAO extends CrudRepository<Mails,Integer> {

}

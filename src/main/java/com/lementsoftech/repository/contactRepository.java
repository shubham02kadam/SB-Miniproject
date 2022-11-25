package com.lementsoftech.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lementsoftech.entiry.Contact;
@Repository
public interface contactRepository extends JpaRepository<Contact, Serializable> {

}

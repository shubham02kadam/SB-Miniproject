package com.lementsoftech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lementsoftech.entiry.Contact;
@Service
public interface ContactService {
	
	public boolean saveContact(Contact contact);
	
	public List<Contact> getAllContact();
	
	public Contact geContactById(Integer contactId);
	
	public boolean deleteContactById(Integer contactId);
	

}

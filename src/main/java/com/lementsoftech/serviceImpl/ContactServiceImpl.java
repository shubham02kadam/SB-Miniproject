package com.lementsoftech.serviceImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lementsoftech.entiry.Contact;
import com.lementsoftech.repository.contactRepository;
import com.lementsoftech.service.ContactService;
@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private contactRepository contactRepo;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSwitch('Y');
		
		Contact save = contactRepo.save(contact);
		
		if(save != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> find=new LinkedList<>();
		
		List<Contact> findAll = contactRepo.findAll();
		
		for(Contact t:findAll) {
			if(t.getActiveSwitch()=='Y') {
				find.add(t);
				
			}
		}
		
		
		return find;
	}

	@Override
	public Contact geContactById(Integer contactId) {
		
		Optional<Contact> findById = contactRepo.findById(contactId);
		
		if(findById.isPresent()) {
			Contact contact = findById.get();
			return contact;
		}
		
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		
		/*boolean status = contactRepo.existsById(contactId);
		
		if(status) {
			contactRepo.deleteById(contactId);
			return true;
			
		}*/
		
		Optional<Contact> findById = contactRepo.findById(contactId);
		
		if(findById.isPresent()) {
			
			Contact contact = findById.get();
			
			contact.setActiveSwitch('N');
			
			contactRepo.save(contact);
			
			return true;
		}
		
		return false;
	}

	

}









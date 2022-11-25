package com.lementsoftech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lementsoftech.entiry.Contact;
import com.lementsoftech.service.ContactService;


@Controller
public class mainController {
	@Autowired
	private ContactService cr;
	
	@GetMapping("/")
	public String index() {
		return"index";
	}
	
	@GetMapping("/contact")
	public String loadContactForm(Model model) {
		Contact contactObj = new Contact();
		model.addAttribute("contact", contactObj);
		return "contactInfo";
	}
	@PostMapping("/saveContact")
	public String saveContact(Contact contact,Model model) {
		boolean saveContact = cr.saveContact(contact);
		
		if(saveContact) {
			model.addAttribute("success", "contact save successfully");
		}else {
			model.addAttribute("error", "contact failed");
		}
		
		return "contactInfo";
		
	}
	@GetMapping("/viewContacts")
	public String viewAllcontacts(Model model) {
		List<Contact> allContact = cr.getAllContact();
		model.addAttribute("contacts", allContact);
		return "contacts";
	}
	@GetMapping("/edit")
	public String editContact(@RequestParam("cid") Integer contactId,Model model) {
		Contact contact=cr.geContactById(contactId);
		model.addAttribute("contact", contact);
		
		return "contactInfo";
	}
	@GetMapping("/delete")
	public String deleteContact(@ModelAttribute("contact")@RequestParam("cid") Integer contactId,Model model) {
		cr.deleteContactById(contactId);
		return "redirect:viewContacts";
	}
	
	
}

package com.tekleads.service;

import java.util.List;

import com.tekleads.domain.Contact;

public interface ContactService {

	public boolean saveContact(Contact contact);

	public List<Contact> retrieveAllActiveContacts();

	public Contact findContactById(Integer contactId);

//	public boolean updateContact(Contact contact);

	public boolean deleteContactById(Integer contactId);
	
	public String validateEmail(String email);

}

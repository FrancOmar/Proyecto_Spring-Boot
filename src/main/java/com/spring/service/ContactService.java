package com.spring.service;

import java.util.List;

import com.spring.entity.Contact;
import com.spring.model.ContactModel;

public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllContacts();
	
	public abstract Contact findContactById(int id);
	
	public abstract void removeContact(int id);
	
	public abstract ContactModel findContactByModel(int id);
}

package com.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.component.ContactConverter;
import com.spring.entity.Contact;
import com.spring.model.ContactModel;
import com.spring.repository.ContactRepository;
import com.spring.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact  contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return contactConverter.converterContact2ContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for (Contact contact : contacts) {
			contactsModel.add(contactConverter.converterContact2ContactModel(contact));
		}
		return contactsModel;
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}
	
	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if(null != contact) {
		contactRepository.delete(contact);
		}
	}

	public ContactModel findContactByModel(int id) {
		return contactConverter.converterContact2ContactModel(findContactById(id));
	}
}

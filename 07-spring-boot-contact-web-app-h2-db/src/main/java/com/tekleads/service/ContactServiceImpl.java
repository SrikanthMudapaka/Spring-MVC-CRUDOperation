package com.tekleads.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekleads.constants.AppConstants;
import com.tekleads.domain.Contact;
import com.tekleads.entity.ContactDtlsEntity;
import com.tekleads.repository.ContactDtlsRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDtlsRepository contactDtlsRepo;

	@Override
	public boolean saveContact(Contact contact) {
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(contact, entity);
		entity.setActiveSw("Y");
		ContactDtlsEntity savedEntity = contactDtlsRepo.save(entity);
		return savedEntity.getContactId() != null;
	}

	@Override
	public List<Contact> retrieveAllActiveContacts() {
		List<Contact> contactsList = new ArrayList();
		List<ContactDtlsEntity> list = contactDtlsRepo.findByActiveSw("Y");
		for (ContactDtlsEntity ce : list) {
			Contact c = new Contact();
			BeanUtils.copyProperties(ce, c);
			contactsList.add(c);
		}
		return contactsList;
	}

	@Override
	public Contact findContactById(Integer contactId) {
		Optional<ContactDtlsEntity> findById = contactDtlsRepo.findById(contactId);
		if (findById.isPresent()) {
			ContactDtlsEntity contactDtlsEntity = findById.get();// source
			Contact c = new Contact();// target
			BeanUtils.copyProperties(contactDtlsEntity, c);
			return c;
		}
		return null;
	}

/*	@Override
	public boolean updateContact(Contact contact) {
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactDtlsEntity save = contactDtlsRepo.save(entity);
		return save != null;
	}
*/
	@Override
	public boolean deleteContactById(Integer contactId) {
		contactDtlsRepo.softDeleteContact("N", contactId);
		return true;
	}

	@Override
	public String validateEmail(String email) {
		ContactDtlsEntity entity = contactDtlsRepo.findByContactEmail(email);
		if (entity != null) {
			return AppConstants.DUPLICATE;
		}
		return AppConstants.UNIQUE;
	}
}

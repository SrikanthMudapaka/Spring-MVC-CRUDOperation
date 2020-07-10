package com.tekleads.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tekleads.entity.ContactDtlsEntity;

public interface ContactDtlsRepository extends CrudRepository<ContactDtlsEntity, Serializable> {

	@Modifying
	@Transactional
	@Query(value = "update ContactDtlsEntity set activeSw=:activeSw where contactId=:contactId")
	public void softDeleteContact(String activeSw, Integer contactId);

	public List<ContactDtlsEntity> findByActiveSw(String activeSw);

	public ContactDtlsEntity findByContactEmail(String email);
}

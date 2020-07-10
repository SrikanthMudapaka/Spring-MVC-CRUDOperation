package com.tekleads.domain;

import lombok.Data;

@Data
public class Contact {

	private Integer contactId;
	private String contactName;
	private Long contactNum;
	private String contactEmail;
	private String activeSw;
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public Long getContactNum() {
		return contactNum;
	}
	public void setContactNum(Long contactNum) {
		this.contactNum = contactNum;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getActiveSw() {
		return activeSw;
	}
	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}
	public Contact(Integer contactId, String contactName, Long contactNum, String contactEmail, String activeSw) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactNum = contactNum;
		this.contactEmail = contactEmail;
		this.activeSw = activeSw;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}

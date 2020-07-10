package com.tekleads.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tekleads.constants.AppConstants;
import com.tekleads.domain.Contact;
import com.tekleads.service.ContactService;

@Controller
public class ContactsController {

	private static final Logger logger = LoggerFactory.getLogger(ContactsController.class);

	@Autowired
	private ContactService contactService;

	public ContactsController() {
		logger.info("Instantiation Completed");
	}

	@RequestMapping(value = "/loadForm")
	public String init(Model model) {
		logger.debug(AppConstants.METHOD_EXE_STARTED_STR);
		Contact c = new Contact();
		model.addAttribute(AppConstants.CONTACT_STR, c);
		logger.debug(AppConstants.METHOD_EXE_ENDED_STR);
		logger.info("save contactform loaded successfully");
		return AppConstants.CONTACT_STR;
	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String handleSubmitBtn(@ModelAttribute(AppConstants.CONTACT_STR) Contact c, Model model) {
		logger.debug(AppConstants.METHOD_EXE_STARTED_STR);
		boolean isSaved = contactService.saveContact(c);
		if (isSaved) {
			model.addAttribute(AppConstants.SUCC_MSG, "Contact Saved");
		} else {
			logger.error("Contact Save Failed");
			model.addAttribute(AppConstants.ERR_MSG, "Failed to save");
		}
		logger.debug(AppConstants.METHOD_EXE_ENDED_STR);
		return AppConstants.CONTACT_STR;
	}

	@RequestMapping("/viewAllContacts")
	public String handleViewAllContactsHyperLink(Model model) {
		logger.debug(AppConstants.METHOD_EXE_STARTED_STR);
		List<Contact> clist = contactService.retrieveAllActiveContacts();
		model.addAttribute("contacts", clist);
		logger.debug(AppConstants.METHOD_EXE_ENDED_STR);
		return AppConstants.VIEW_CONTACTS_STR;
	}

	@RequestMapping("/editContact")
	public String handleEditAndUpdateLink(HttpServletRequest req, Model model) {
		logger.debug(AppConstants.METHOD_EXE_STARTED_STR);
		String cid = req.getParameter(AppConstants.CID_STR);
		Contact c = contactService.findContactById(Integer.parseInt(cid));
		model.addAttribute(AppConstants.CONTACT_STR, c);
		logger.debug(AppConstants.METHOD_EXE_ENDED_STR);
		return AppConstants.CONTACT_STR;
	}

	@RequestMapping("/deleteContact")
	public String handleDeleteLink(HttpServletRequest req, RedirectAttributes ra) {
		logger.debug(AppConstants.METHOD_EXE_STARTED_STR);
		String cid = req.getParameter(AppConstants.CID_STR);
		boolean isDeleted = contactService.deleteContactById(Integer.parseInt(cid));
		if (isDeleted) {
			ra.addFlashAttribute(AppConstants.SUCC_MSG, "Contact Deleted Successfully");
		}
		logger.debug(AppConstants.METHOD_EXE_ENDED_STR);
		logger.info("request redirect to viewContacts");
		return AppConstants.REDIRECT_VIEW_ALL_CONTACTS;
	}
	
	@RequestMapping(value="/validateEmail")
	public @ResponseBody String validateEmail(@RequestParam("email") String email) {
		return  contactService.validateEmail(email);
	}
}

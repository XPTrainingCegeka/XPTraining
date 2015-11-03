package org.cegeka.petshop;

import java.util.HashSet;
import java.util.Set;

import javax.mail.MessagingException;

import com.google.common.collect.ImmutableSet;

public class Shop {
	private EmailNotificationService service;
	private Set<String> itemList = new HashSet<String>();

	public Shop(EmailNotificationService notificationService) {
		service = notificationService;
	}

	public void addItem(String item) {
		itemList.add(item);
		try {
			service.sendEmail("sample", item);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.err.println("Could not send email.Will skip it");
		}
	}

	public Set<String> getItemsInStock() {
		return ImmutableSet.copyOf(itemList);
	}
}

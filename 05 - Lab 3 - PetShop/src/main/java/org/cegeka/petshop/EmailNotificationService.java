package org.cegeka.petshop;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailNotificationService {

	private int port;
	private String host;

	public EmailNotificationService(int port, String host) {
		this.port = port;
		this.host = host;

	}

	void sendEmail(String recipient, String content) throws MessagingException {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost(host);
		sender.setPort(port);
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setTo(recipient);
		helper.setText(content);

		sender.send(message);
	}
}

package org.cegeka.petshop;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.subethamail.wiser.Wiser;

public class PetShopTest {

	private static final int SMTP_TEST_PORT = 9000;
	private static final String SMPT_TEST_HOST = "localhost";
	private Shop shop;
	private static Wiser wiser;

	@BeforeClass
	public static void setUpTestClass() {

		wiser = new Wiser();
		wiser.setPort(SMTP_TEST_PORT);
		wiser.setHostname(SMPT_TEST_HOST);
		wiser.start();
	}

	@Before
	public void setUpTest() {
		shop = new Shop(new EmailNotificationService(SMTP_TEST_PORT, SMPT_TEST_HOST));
		wiser.getMessages().clear();
	}

	@AfterClass
	public static void tearDownTestClass() {
		wiser.stop();
	}

	private void addItem(String item) {
		shop.addItem(item);
	}

	@Test
	public void addItem_whenItem_thenAddsItemToStock() {
		String item = "Doggy Gucci bag";
		addItem(item);

		Set<String> items = shop.getItemsInStock();

		assertThat(items.contains(item)).isTrue();
	}

	@Test
	public void addItem_whenItem_thenEmailIsSend() throws IOException, MessagingException {
		String item = "Doggy Gucci bag";
		addItem(item);

		assertThat(wiser.getMessages()).hasSize(1);

		MimeMessage mimeMessage = wiser.getMessages().get(0).getMimeMessage();
		assertThat(mimeMessage.getContent().toString()).isEqualTo(item + "\r\n");

	}

}

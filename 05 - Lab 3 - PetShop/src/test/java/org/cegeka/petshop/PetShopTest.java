package org.cegeka.petshop;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.subethamail.wiser.Wiser;

public class PetShopTest {

	private static final int SMTP_TEST_PORT = 9000;
	private static final String SMPT_TEST_HOST = "localhost";
	private Shop shop;
	private Wiser wiser;

	@Before
	public void setup() {
		shop = new Shop(new EmailNotificationService(SMTP_TEST_PORT, SMPT_TEST_HOST));

		wiser = new Wiser();
		wiser.setPort(SMTP_TEST_PORT);
		wiser.setHostname(SMPT_TEST_HOST);
		wiser.start();
	}

	@After
	public void tearDown() {
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
	public void addItem_whenItem_thenEmailIsSend() {
		String item = "Doggy Gucci bag";
		addItem(item);

		assertThat(wiser.getMessages()).hasSize(1);

	}

}

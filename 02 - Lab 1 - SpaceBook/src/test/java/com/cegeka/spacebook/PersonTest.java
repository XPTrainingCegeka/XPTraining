package com.cegeka.spacebook;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;

public class PersonTest {

	@Test
	public void personIsCreatedWithAValidUsername() {
		Person person = new Person("ayan");
		assertThat(person).isNotNull();
		assertThat(person.getUserName()).isEqualTo("ayan");
	}

	@Test(expected = InvalidUsernameException.class)
	public void personCannotBeCreatedWithEmptyUsername() {
		new Person("");
	}

	@Test(expected = InvalidUsernameException.class)
	public void personCannotBeCreatedWithNullAsParameter() {
		new Person(null);
	}

	@Test(expected = InvalidUsernameException.class)
	public void personCannotBeCreatedWithIncludeSpaced() {
		new Person(" xx ");
	}

	@Test
	public void personCanHaveFriend() {
		Person p = new Person("nikola");
		p.addFriend(new Person("ayan"));
		assertThat(p.getFriends()).isNotEmpty().extracting(Person::getUserName).contains("ayan");
	}

	@Test
	public void presonsRelationIsBidirectional() {
		Person p = new Person("nikola");
		Person p2 = new Person("ayan");
		p.addFriend(p2);
		assertThat(p.getFriends()).isNotEmpty().extracting(Person::getUserName).contains("ayan");
		assertThat(p2.getFriends()).isNotEmpty().extracting(Person::getUserName).contains("nikola");
	}

	@Test(expected = AddingFriendException.class)
	public void addingYourselfIsProhibited() {
		Person p = new Person("x");
		p.addFriend(p);
	}

	@Test
	public void presonCanReceiveMessagesFromFriends() {
		Person p = new Person("ayan");
		Person p2 = new Person("nikola");
		Message message = new Message(new Date(), p2, "Hello");
		p.sendMessage(message);

	}
}

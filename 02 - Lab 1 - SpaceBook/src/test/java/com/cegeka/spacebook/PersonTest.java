package com.cegeka.spacebook;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PersonTest {

	@Test
	public void Person_givenUsername_thenPersonCreated() {
		Person person = new Person("randomUsername");

		Assertions.assertThat(person).isNotNull();
	}

	@Test(expected = IllegalArgumentException.class)
	public void Person_givenUsernameWithSpacesOrEmpty_thenPersonNotCreated() {
		new Person("User name");
		new Person("");
	}

	@Test
	public void Person_hasNoneEmptyFriendsList() {
		Person person = new Person("username");
		person.getFriends().add(new Person("friend"));

		Assertions.assertThat(person.getFriends())
				.isNotEmpty()
				.extracting(Person::getUsername)
				.contains("friend");
	}

	@Test
	public void Person_givenNewFriend_thenFriendAdded() {
		Person person = new Person("me");
		Person friend = new Person("him");
		person.addFriend(friend);
		Assertions.assertThat(person.getFriends()).isNotEmpty().contains(friend);
		Assertions.assertThat(friend.getFriends()).isNotEmpty().contains(person);
	}

}

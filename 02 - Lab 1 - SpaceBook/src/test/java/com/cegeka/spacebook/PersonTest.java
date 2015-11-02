package com.cegeka.spacebook;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class PersonTest {

	@Test
	public void Person_givenUsername_thenPersonCreated() {
		Person person = new Person("randomUsername");

		assertThat(person).isNotNull();
	}

	@Test
	public void Person_givenUserName_thenUsernameIsSet() {
		Person person = new Person("randomUsername");

		assertThat(person.getUsername()).isEqualTo("randomUsername");
	}

	@Test(expected = IllegalArgumentException.class)
	public void Person_givenUsernameNull_thenExceptionIsThrown() {
		new Person(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Person_givenUsernameEmpty_thenExceptionIsThrown() {
		new Person("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void Person_givenUsernameSpaces_thenExceptionIsThrown() {
		new Person("   ");
	}

	@Test
	public void Person_givenUsername_thenUserHasEmptyListOfFriends() {
		Person person = new Person("randomUsername");
		assertThat(person.getFriends()).isEmpty();
	}
}

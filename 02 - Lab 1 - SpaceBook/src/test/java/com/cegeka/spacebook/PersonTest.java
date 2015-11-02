package com.cegeka.spacebook;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PersonTest {

	static final String SAMPLE_USERNAME = "randomUsername";

	@Test
	public void Person_givenUsername_thenPersonCreated() throws InvalidUsernameException {
		Person person = new Person("randomUsername");

		assertThat(person).isNotNull();
	}

	@Test
	public void Person_givenUsername_thenUserNameIsCorrectlySet() throws InvalidUsernameException {
		Person person = new Person(SAMPLE_USERNAME);

		assertThat(person.getUserName()).isEqualTo(SAMPLE_USERNAME);
	}
	
	@Test(expected = InvalidUsernameException.class)
	public void Person_givenEmptyUsername_thenExceptionIsThrown() throws InvalidUsernameException {
		 new Person("");
	}
	
	@Test(expected = InvalidUsernameException.class)
	public void Person_givenLongEmptyUsername_thenExceptionIsThrown() throws InvalidUsernameException {
		new Person("\t");
	}
	
	@Test(expected = InvalidUsernameException.class)
	public void Person_givenNullUsername_thenExceptionIsThrown() throws InvalidUsernameException {
		new Person(null);
	}
	

}

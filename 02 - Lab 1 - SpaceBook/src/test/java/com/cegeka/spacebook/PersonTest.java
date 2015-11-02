package com.cegeka.spacebook;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import com.cegeka.spacebook.exception.InvalidUserNameException;
import com.cegeka.spacebook.exception.SpaceBookException;

public class PersonTest {

	static final String SAMPLE_USERNAME = "randomUsername";

	@Test
	public void Person_givenUsername_thenPersonCreated() throws SpaceBookException {
		Person person = new Person("randomUsername");

		assertThat(person).isNotNull();
	}

	@Test
	public void Person_givenUsername_thenUserNameIsCorrectlySet() throws SpaceBookException {
		Person person = new Person(SAMPLE_USERNAME);

		assertThat(person.getUserName()).isEqualTo(SAMPLE_USERNAME);
	}

	@Test(expected = InvalidUserNameException.class)
	public void Person_givenEmptyUsername_thenExceptionIsThrown() throws SpaceBookException {
		new Person("");
	}

	@Test(expected = InvalidUserNameException.class)
	public void Person_givenLongEmptyUsername_thenExceptionIsThrown() throws SpaceBookException {
		new Person("\t");
	}

	@Test(expected = InvalidUserNameException.class)
	public void Person_givenNullUsername_thenExceptionIsThrown() throws SpaceBookException {
		new Person(null);
	}

}

package com.cegeka.spacebook;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.cegeka.spacebook.exception.MessageSendingNotAllowed;
import com.cegeka.spacebook.exception.SpaceBookException;

public class PersonFriendsTest {

	Person p1, p2;

	@Before
	public void setUpTest() throws SpaceBookException {
		p1 = new Person("p1");
		p2 = new Person("p2");
	}

	@Test
	public void Person_whenPersonCreated_thenHasNoFriends() throws SpaceBookException {
		Assertions.assertThat(new Person("username").getFriends()).isEmpty();
	}

	@Test
	public void Person_whenFriendAdded_thenPersonHasFriend() throws SpaceBookException {
		p1.addFriend(p2);
		Assertions.assertThat(p1.getFriends()).containsOnly(p2);
	}

	@Test
	public void Person_whenFriendAdded_thenFriendshipIsBidirectional() throws SpaceBookException {
		p1.addFriend(p2);
		Assertions.assertThat(p1.getFriends()).containsOnly(p2);
		Assertions.assertThat(p2.getFriends()).containsOnly(p1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Person_whenPersonIsAddedToOwnFriends_thenExceptionIsThrown()
			throws IllegalArgumentException, SpaceBookException {
		p1.addFriend(p1);
	}

	@Test
	public void Person_whenPersonHasFriends_friendCanSendMessageToPerson()
			throws IllegalArgumentException, SpaceBookException {
		p1.addFriend(p2);
		p1.sendMessageTo(p2,"hello");

	}

	@Test(expected = MessageSendingNotAllowed.class)
	public void Person_whenPersonsAreNotFriends_thenTheyCantSendMessages()
			throws IllegalArgumentException, SpaceBookException {
		p1.sendMessageTo(p2, "hello");
	}

}
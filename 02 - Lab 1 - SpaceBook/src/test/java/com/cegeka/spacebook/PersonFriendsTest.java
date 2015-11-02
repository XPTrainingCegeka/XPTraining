package com.cegeka.spacebook;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class PersonFriendsTest {
	@Test
	public void Person_whenPersonCreated_thenHasNoFriends() throws InvalidUsernameException {
		Assertions.assertThat(new Person("username").getFriends()).isEmpty();
	}
	
	@Test
	public void Person_whenFriendAdded_thenPersonHasFriend() throws InvalidUsernameException {
		Person p1 = new Person("person1");
		Person p2 = new Person("person2");
		p1.addFriend(p2);
		Assertions.assertThat(p1.getFriends()).containsOnly(p2);
		
	}

	@Test
	public void Person_whenFriendAdded_thenFriendshipIsBidirectional() throws InvalidUsernameException {
		Person p1 = new Person("person1");
		Person p2 = new Person("person2");
		p1.addFriend(p2);
		Assertions.assertThat(p1.getFriends()).containsOnly(p2);
		Assertions.assertThat(p2.getFriends()).containsOnly(p1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void Person_whenPersonIsAddedToOwnFriends_thenExceptionIsThrown() throws IllegalArgumentException, InvalidUsernameException {
		Person p = new Person("username");
		p.addFriend(p);
	}

}
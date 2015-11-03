package com.cegeka.spacebook;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String username;
	private List<Person> friends;

	public Person(String username) {

		if (isUsernameInvalid(username)) {
			throw new IllegalArgumentException("Invalid User name: should be(without spaces and not empty).");
		}
		this.username = username;
		this.friends = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public boolean isUsernameInvalid(String param) {
		return (param == null || param.isEmpty() || param.contains(" "));
	}

	public List<Person> getFriends() {
		return friends;
	}

	public void addFriend(Person friend) {
		if (friend != this) {
			friends.add(friend);
			friend.getFriends().add(this);
		}
	}

}

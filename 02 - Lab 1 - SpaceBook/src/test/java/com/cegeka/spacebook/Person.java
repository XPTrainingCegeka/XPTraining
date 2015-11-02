package com.cegeka.spacebook;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String username;
	private List<Person> friends = new ArrayList<>();

	public Person(String username) {
		if (username == null) {
			throw new IllegalArgumentException("Username cannot be null");
		}

		String trimmedUsername = username.trim();
		if (trimmedUsername.isEmpty()) {
			throw new IllegalArgumentException("Username cannot be null, empty or spaces");
		}
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public List<Person> getFriends() {
		return friends;
	}

}

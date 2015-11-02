package com.cegeka.spacebook;

import java.util.ArrayList;
import java.util.Collection;

public class Person {

	private String username;
	private Collection<Person> friendsList;

	public Person(String username) throws InvalidUsernameException {
		if (username == null || username.trim().equals("")) {
			throw new InvalidUsernameException();
		}
		this.username = username;

		friendsList = new ArrayList<Person>();
	}

	public String getUserName() {
		return username;
	}

	public Collection<Person> getFriends() {
		return friendsList;
	}

	public void addFriend(Person friendPerson) {
		if(friendPerson == this) {
			throw new IllegalArgumentException();
		}
		if(!friendsList.contains(friendPerson)) {
			friendsList.add(friendPerson);
			friendPerson.addFriend(this);
		}
	}

}

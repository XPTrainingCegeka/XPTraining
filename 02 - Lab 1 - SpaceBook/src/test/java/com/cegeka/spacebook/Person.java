package com.cegeka.spacebook;

import java.util.HashSet;
import java.util.Set;

public class Person {

	private final String MESSAGE = "User name can not be null, empty or contain spaces.";

	private String userName;

	private Set<Person> friends;

	public Person(String userName) {
		if (userName == null || userName.equals("") || userName.contains(" ")) {
			throw new InvalidUsernameException(MESSAGE);
		}

		this.userName = userName;

		friends = new HashSet<>();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Person> getFriends() {
		return friends;
	}

	public void addFriend(Person person) {

		if (this.equals(person)) {
			throw new AddingFriendException();
		}

		if (!this.friends.contains(person)) {
			friends.add(person);
			person.addFriend(this);
		}
	}

	public void sendMessage(Message message) {
		// TODO Auto-generated method stub

	}

}

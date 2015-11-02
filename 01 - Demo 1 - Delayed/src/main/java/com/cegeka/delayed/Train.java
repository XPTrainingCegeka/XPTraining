package com.cegeka.delayed;

public class Train {

	private int hoursDelayed;

	public Train(int hoursDelayed) {
		this.hoursDelayed = hoursDelayed;

	}

	public int getHoursDelayed() {
		return this.hoursDelayed;
	}

	public void setHoursDelayed(int hoursDelayed) {

	}

	public String customerSatifisfaction() throws WorldApocalypseException {
		switch (hoursDelayed) {
		case 0:
			return "Nice 'n' rolling!";
		case 1:
			return "Just another day at the train ...";
		case 2:
			return "This train is annoying me!";
		case 3:
			return "B-u-u-urn it!";
		default:
			throw new WorldApocalypseException("I cannot wait forever!!");
		}
	}

}

package com.cegeka.delayed;

import java.math.BigDecimal;

public class Train {

	private int hoursDelayed;
	
    public Train(int hoursDelayed) {
    	this.hoursDelayed = hoursDelayed;
    }

    public int getHoursDelayed() {
    	return hoursDelayed;
    }

    public void setHoursDelayed(int hoursDelayed) {

    }

	public String customerSatisfaction() {
		switch(hoursDelayed) {
		case 0:
			return "Nice 'n' rolling!";
		case 1:
			return "Just another day at the train ...";
		case 2:
			return "This train is annoying me!";
		case 3:
			return "B-u-u-urn it!";
		}
		return null;
	}
}

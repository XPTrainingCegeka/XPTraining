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
    	this.hoursDelayed = hoursDelayed;
    }

	public String customerSatisfaction() {

		String satisfaction = null;
		switch (hoursDelayed) {
		case 0:
			satisfaction = "case 0";
			break;
		case 1:
			satisfaction = "case 1";
			break;
		case 2:
			satisfaction = "This train is annoying me!";
			break;

		default:
			break;
		}
		return satisfaction;
	}


}

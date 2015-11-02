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
		// TODO Auto-generated method stub
		String satisfaction = null;
		switch (hoursDelayed) {
		case 0:
			satisfaction = "case 0";
		case 1:
			return "case 1";
		case 2:
			return "This train is annoying me!";
		case 3:
			satisfaction = "case 3";
		default:
			break;
		}
		return satisfaction;
	}


}

package com.cegeka.delayed;

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
		String result ;
		switch(hoursDelayed) {
			case 0: 
				result = "Nice ‘n’ rolling!";
				break;
			case 1:
				result = "Just another day at the train …";
				break;
			case 2:
				result = "This train is annoying me!";
				break;
			case 3:
				result = "B-u-u-urn it!";
				break;
			default:
				throw new RuntimeException("The world explodes");
				
		}
		return result;		
	}
}

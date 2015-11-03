package stub;

import stub.DayService;

public class Greeting {

	DayService dayService;

	public String getGreeting() {
		if (dayService.isDayNow()) {
			return "Good Day";
		} else {
			return "Good Morning";
		}
	}

	protected void setDayService(DayService dayService) {
		this.dayService = dayService;
	}

}

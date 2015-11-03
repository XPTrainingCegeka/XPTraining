package stub;

import java.util.Calendar;

public class Greeting {
	
	private TimeService ts;
	
	
	public Greeting(TimeService ts) {
		this.ts = ts;
	}


	public String getGreeting() {
		if(ts.isMorning(Calendar.getInstance())) {
			return "Good Morning";
		}
		return "Good Day sir";
	}

}

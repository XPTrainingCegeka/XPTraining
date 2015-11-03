package stub;

import java.util.Calendar;

public class TimeService {
	
	public boolean isMorning(Calendar calendar) {
		if(calendar.get(Calendar.HOUR) < 10) {
			return true;
		}
		return false;
	}

}

package org.cegeka.vampireslayer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Hunter {
    public boolean canHunt(Date huntingTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(huntingTime);
        int huntingHour = calendar.get(Calendar.HOUR_OF_DAY);
        int huntingMinute = calendar.get(Calendar.MINUTE);
        int huntingSecond = calendar.get(Calendar.SECOND);
        int huntingMilliSecond = calendar.get(Calendar.MILLISECOND);
    
        return huntingHour >= 0 && huntingHour <= 6;
    }
}

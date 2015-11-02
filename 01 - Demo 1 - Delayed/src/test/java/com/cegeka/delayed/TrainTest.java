package com.cegeka.delayed;

import com.cegeka.delayed.Train;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class TrainTest {

    @Test
    public void getHoursDelayed_givenTrainAndHoursDelayed_correctHoursDelayedReturned() {
        Train train = new Train(2);

        assertThat(train.getHoursDelayed()).isEqualTo(2);
        assertThat(train.customerSatisfaction()).isEqualTo("This train is annoying me!");
    }
    
    @Test
    public void getHoursDelayed_shouldMapSatisfaction() {
    	Train train = new Train(1);
    	
    	assertThat(train.getHoursDelayed()).isEqualTo(1);
    	assertThat(train.customerSatisfaction()).isEqualTo("case 1");
    	
    	train.setHoursDelayed(0);
    	assertThat(train.getHoursDelayed()).isEqualTo(1);
    	assertThat(train.customerSatisfaction()).isEqualTo("case 0");
    }
    
}

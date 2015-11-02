package com.cegeka.delayed;

import com.cegeka.delayed.Train;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class TrainTest {

    @Test
    public void getHoursDelayed_givenTrainAndHours2_correctHoursDelayedReturned() {
        Train train = new Train(2);

        assertThat(train.getHoursDelayed()).isEqualTo(2);
    }
    
    @Test
    public void getHoursDelayed_givenTrainAndHours0_correctCustomerSatisfactionReturned() {
    	Train train = new Train(0);
    	
        assertThat(train.customerSatisfaction()).isEqualTo("Nice 'n' rolling!");
    }
    
    @Test
    public void getHoursDelayed_givenTrainAndHours1_correctCustomerSatisfactionReturned() {
    	Train train = new Train(1);
    	
        assertThat(train.customerSatisfaction()).isEqualTo("Just another day at the train ...");
    }

    @Test
    public void getHoursDelayed_givenTrainAndHours2_correctCustomerSatisfactionReturned() {
    	Train train = new Train(2);
    	
        assertThat(train.customerSatisfaction()).isEqualTo("This train is annoying me!");
    }
    
    @Test
    public void getHoursDelayed_givenTrainAndHours3_correctHoursDelayedReturned() {
    	Train train = new Train(3);
    	
        assertThat(train.customerSatisfaction()).isEqualTo("B-u-u-urn it!");
    }

}

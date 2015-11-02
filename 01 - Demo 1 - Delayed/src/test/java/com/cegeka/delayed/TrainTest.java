package com.cegeka.delayed;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class TrainTest {

    @Test
    public void getHoursDelayed_givenTrainAndHoursDelayed_correctHoursDelayedReturned() {
        Train train = new Train(2);

        assertThat(train.getHoursDelayed()).isEqualTo(2);
        assertThat(train.customerSatisfaction()).isEqualTo("This train is annoying me!");
    }
    
    @Test
    public void testThreeHours() {
        Train train = new Train(3);

        assertThat(train.getHoursDelayed()).isEqualTo(3);
        assertThat(train.customerSatisfaction()).isEqualTo("B-u-u-urn it!");
    }
    
    @Test
    public void testOneHour() {
        Train train = new Train(1);

        assertThat(train.getHoursDelayed()).isEqualTo(1);
        assertThat(train.customerSatisfaction()).isEqualTo("Just another day at the train …");
    }
    
    
    @Test
    public void testZeroHour() {
        Train train = new Train(0);

        assertThat(train.getHoursDelayed()).isEqualTo(0);
        assertThat(train.customerSatisfaction()).isEqualTo("Nice ‘n’ rolling!");
    }
    
    @Test(expected = RuntimeException.class)
    public void testFourHours() {
        Train train = new Train(4);

        assertThat(train.getHoursDelayed()).isEqualTo(4);
        train.customerSatisfaction();
    }
}

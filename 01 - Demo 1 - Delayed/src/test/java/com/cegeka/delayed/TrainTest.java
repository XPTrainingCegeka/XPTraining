package com.cegeka.delayed;

import com.cegeka.delayed.Train;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

import java.util.stream.IntStream;

public class TrainTest {

	@Test
	public void getHoursDelayed_givenTrainAndHoursDelayed_correctHoursDelayedReturned()
			throws WorldApocalypseException {
		Train train = new Train(0);
		assertThat(train.getHoursDelayed()).isEqualTo(0);
	}

	@Test
	public void getHoursDelayed_givenTrainAndHoursDelayed_correctCustomerSatisfactionReturned()
			throws WorldApocalypseException {
		Train train = new Train(0);

		assertThat(train.customerSatifisfaction()).isEqualTo("Nice 'n' rolling!");

		train = new Train(1);
		assertThat(train.customerSatifisfaction()).isEqualTo("Just another day at the train ...");

		train = new Train(2);
		assertThat(train.customerSatifisfaction()).isEqualTo("This train is annoying me!");

		train = new Train(3);
		assertThat(train.customerSatifisfaction()).isEqualTo("B-u-u-urn it!");

	}

	@Test(expected = WorldApocalypseException.class)
	public void getHoursDelayed_givenTrainAndHoursDelayed_exceptionThrown() throws WorldApocalypseException {

		Train train = new Train(5778);
		train.customerSatifisfaction();
	}
}

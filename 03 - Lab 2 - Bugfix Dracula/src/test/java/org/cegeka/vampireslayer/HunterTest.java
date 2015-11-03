package org.cegeka.vampireslayer;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class HunterTest {
	private Hunter hunter;

	private Date setUpDate(int hour, int minute) {
		// LocalDateTime.of(2014, Month.APRIL, hour, minute);
		Calendar calendar = Calendar.getInstance();
		Date huntingTime;

		calendar.set(2014, Calendar.APRIL, 12, hour, minute);
		huntingTime = calendar.getTime();
		return huntingTime;
	}

	@Before
	public void setup() {
		hunter = new Hunter();
	}

	@Test
	public void canHunt_givenDayTime_thenCannotHunt() {

		Date huntingTime = setUpDate(16, 1);

		assertThat(hunter.canHunt(huntingTime)).isFalse();
	}

	@Test
	public void canHunt_givenNightTime_thenCanHunt() {
		Date huntingTime = setUpDate(1, 1);
		assertThat(hunter.canHunt(huntingTime)).isTrue();
	}

	@Test
	public void canHunt_givenMidnight_thenCanHunt() {
		Date huntingTime = setUpDate(0, 0);
		assertThat(hunter.canHunt(huntingTime)).isTrue();
	}

	@Test
	public void canHunt_given6am_thenCanHunt() {
		Date huntingTime = setUpDate(6, 0);
		assertThat(hunter.canHunt(huntingTime)).isTrue();
	}

	@Test
	public void canHunt_given6amPlus1min_thenCanHunt() {
		Date huntingTime = setUpDate(6, 1);
		assertThat(hunter.canHunt(huntingTime)).isFalse();
	}
}

package stub;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GreetingTest {

	private Greeting g;

	private DayService service;

	@Before
	public void setUp() throws Exception {
		g = new Greeting();

		service = Mockito.mock(DayService.class);
		g.setDayService(service);
	}

	@Test
	public void morning() {
		String s = g.getGreeting();
		Mockito.when(service.isDayNow()).thenReturn(true);
		assertThat(s).isEqualTo("Good Morning");
	}

	@Test
	public void day() {
		String s = g.getGreeting();
		Mockito.when(service.isDayNow()).thenReturn(false);
		assertThat(s).isEqualTo("Good Day");
	}
}

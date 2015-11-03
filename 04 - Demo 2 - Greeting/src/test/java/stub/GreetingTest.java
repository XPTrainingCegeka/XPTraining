package stub;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GreetingTest {

	private Greeting g;
	private TimeService ts;
	
	@Before
	public void setUp() throws Exception {
		ts = Mockito.mock(TimeService.class);
		g  = new Greeting(ts);
		
	}

	@Test
	public void morning(){
		Mockito.when(ts.isMorning(any(Calendar.class))).thenReturn(true);
		String s = g.getGreeting();
		assertEquals("Good Morning", s);
	}
	@Test
	public void afternoon(){
		Mockito.when(ts.isMorning(any(Calendar.class))).thenReturn(false);
		String s = g.getGreeting();
		assertEquals("Good Day sir", s);
	}
	
}

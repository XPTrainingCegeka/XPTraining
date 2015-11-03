package movierental;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import movierental.movies.Movie;

public class CustomerTest {

	@Test
	public void testCustomer() {
		Customer c = new CustomerBuilder().build();
		assertThat(c).isNotNull();
	}

	@Test
	public void testAddRental() {
		Customer customer2 = new CustomerBuilder().withName("Sallie").build();
		Movie movie1 = new Movie("Gone with the Wind", Movie.REGULAR);
		Rental rental1 = new Rental(movie1, 3); // 3 day rental
		customer2.addRental(rental1);
	}

	@Test
	public void testGetName() {
		Customer c = new Customer("David");
		assertThat(c.getName()).isEqualTo("David");
	}

	// TODO make test for price breaks in code.
}

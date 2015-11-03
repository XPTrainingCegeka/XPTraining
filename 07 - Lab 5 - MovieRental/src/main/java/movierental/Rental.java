package movierental;

import movierental.movies.Movie;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public double getPrice() {
		return _movie.getPriceForDays(getDaysRented());
	}

	public int getFrequentPointForRental() {
		// add frequent renter points
		int frequentRenterPoints = 1;
		// add bonus for a two day new release rental
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

	public String getStatement() {
		return getMovie().getTitle() + "\t" + String.valueOf(getPrice()) + "\n";
	}

}

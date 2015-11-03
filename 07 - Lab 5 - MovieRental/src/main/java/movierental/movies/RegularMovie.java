package movierental.movies;

public class RegularMovie extends Movie {

	public RegularMovie(String title) {
		super(title, REGULAR);
	}

	@Override
	public double getPriceForDays(int noOfDays) {
		double thisAmount = 0;
		thisAmount = 2;
		if (noOfDays > 2)
			thisAmount += (noOfDays - 2) * 1.5;
		return thisAmount;
	}

}

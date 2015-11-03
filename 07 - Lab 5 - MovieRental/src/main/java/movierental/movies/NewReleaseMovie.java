package movierental.movies;

public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(String title) {
		super(title, NEW_RELEASE);
	}

	@Override
	public double getPriceForDays(int noOfDays) {
		double thisAmount = 0;
		thisAmount += noOfDays * 3;
		return thisAmount;
	}
}

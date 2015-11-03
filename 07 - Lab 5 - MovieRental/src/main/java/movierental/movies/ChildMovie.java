package movierental.movies;

public class ChildMovie extends Movie {

	public ChildMovie(String title) {
		super(title, CHILDRENS);
	}

	@Override
	public double getPriceForDays(int noOfDays) {
		double thisAmount = 0;
		thisAmount = 1.5;
		if (noOfDays > 3)
			thisAmount += (noOfDays - 3) * 1.5;
		return thisAmount;
	}

}

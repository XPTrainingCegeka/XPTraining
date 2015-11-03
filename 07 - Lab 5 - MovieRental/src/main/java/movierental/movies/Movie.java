package movierental.movies;

public class Movie {

	public static final int CHILDRENS = 2;
	public static final int NEW_RELEASE = 1;
	public static final int REGULAR = 0;

	private String _title;
	private int _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		_priceCode = arg;
	}

	public String getTitle() {
		return _title;
	}

	public double getPriceForDays(int noOfDays) {
		double thisAmount = 0;
		// determine amounts for each line
		switch (getPriceCode()) {
		case Movie.REGULAR:
			thisAmount = 2;
			if (noOfDays > 2)
				thisAmount += (noOfDays - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += noOfDays * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount = 1.5;
			if (noOfDays > 3)
				thisAmount += (noOfDays - 3) * 1.5;
			break;
		}
		return thisAmount;
	}

}

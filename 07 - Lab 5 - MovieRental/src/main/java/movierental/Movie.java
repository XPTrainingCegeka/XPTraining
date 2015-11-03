package movierental;

public abstract class Movie {

	
	private String _title;
	private int _priceCode;
	
	public Movie(String title) {
		_title = title;
	}
	
	public String getTitle() {
		return _title;
	}
	
	public abstract double makeCalc(int daysRented);
	
	
	
}

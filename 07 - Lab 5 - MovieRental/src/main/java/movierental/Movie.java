package movierental;

public class Movie {

	private String _title;

	public Movie(String title) {
		_title = title;
	}

	public String getTitle() {
		return _title;
	}

	public double calculateRentalPrice(int days) {
		return 2 + Math.max(days - 2, 0) * 1.5;
	}

	public int getRentingBonus(int days) {
		return 1;
	}
}

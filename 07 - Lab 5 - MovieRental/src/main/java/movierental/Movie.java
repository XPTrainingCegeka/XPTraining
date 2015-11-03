package movierental;

public class Movie {

	private String _title;
	private int _freeDays;
	private double _initialPrice;
	private double _factor;

	public Movie(String title) {
		this(title, 2, 2, 1.5);
	}

	protected Movie(String title, int freeDays, double initialPrice, double factor) {
		_title = title;
		_freeDays = freeDays;
		_initialPrice = initialPrice;
		_factor = factor;
	}

	public String getTitle() {
		return _title;
	}

	public double calculateRentalPrice(int days) {
		return getInitialPrice() + Math.max(days - getFreeDays(), 0) * getFactor();
	}

	public int getRentingBonus(int days) {
		return 1;
	}

	public int getFreeDays() {
		return _freeDays;
	}

	public double getInitialPrice() {
		return _initialPrice;
	}

	public double getFactor() {
		return _factor;
	}

}

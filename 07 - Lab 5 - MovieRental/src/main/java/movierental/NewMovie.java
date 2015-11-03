package movierental;

public class NewMovie extends Movie {

	public NewMovie(String title) {
		super(title);
	}

	@Override
	public double calculateRentalPrice(int days) {
		return days * 3;
	}

	@Override
	public int getRentingBonus(int days) {
		return days > 1 ? 2 : super.getRentingBonus(days);
	}

}

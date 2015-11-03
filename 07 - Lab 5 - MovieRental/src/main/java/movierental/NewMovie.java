package movierental;

public class NewMovie extends Movie {

	public NewMovie(String title) {
		super(title, 0, 0, 3);
	}

	@Override
	public int getRentingBonus(int days) {
		return days > 1 ? 2 : super.getRentingBonus(days);
	}

}

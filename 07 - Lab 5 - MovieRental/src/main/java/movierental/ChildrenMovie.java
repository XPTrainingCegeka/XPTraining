package movierental;

public class ChildrenMovie extends Movie {

	public ChildrenMovie(String title) {
		super(title);
	}

	@Override
	public double calculateRentalPrice(int days) {
		return 1.5 + Math.max(days - 3, 0) * 1.5;
	}

}

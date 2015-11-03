package movierental;

public class NewReleaseMovie extends Movie{

	public NewReleaseMovie(String title) {
		super(title);
	}

	@Override
	public double makeCalc(int daysRented) {
		// TODO Auto-generated method stub
		return daysRented * 3;
	}

}

package movierental;

public class NewRelease implements MovieCalculation {

	@Override
	public double calculateAmount(int daysRented) {
		return (double) daysRented * 3;
	}

}

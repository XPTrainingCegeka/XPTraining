package movierental;

public class RegularMovie implements MovieCalculation {
	public String name;

	public RegularMovie() {
	}

	@Override
	public double calculateAmount(int daysRented) {
		double amount = 2;
		if (daysRented > 2)
			amount += (daysRented - 2) * 1.5;
		return amount;
	}
}
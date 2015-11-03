package movierental;

public class ChildrenMovie implements MovieCalculation {

	@Override
	public double calculateAmount(int daysRented) {
		double amount = 1.5;
		if (daysRented > 3)
			amount += (daysRented - 3) * 1.5;
		return amount;
	}

}

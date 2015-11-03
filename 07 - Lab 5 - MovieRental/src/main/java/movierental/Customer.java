package movierental;
import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String _name;
	private List<Rental> _rentals = new ArrayList<Rental>();
	
	public Customer(String name) {
		_name = name;
	}
	
	public void addRental(Rental arg) {
		_rentals.add(arg);
	}
	
	public String getName() {
		return _name;
	}
	
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuffer result = new StringBuffer("Rental Record for " + getName() + "\n");
		
		for (Rental each: _rentals) {
			double thisAmount = each.getMovie().makeCalc(each.getDaysRented());
			
			//determine amounts for each line
		
			
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			frequentRenterPoints = addBonusForNewRelease(frequentRenterPoints, each);
			
			// show figures for this rental
			result.append("\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n");
			totalAmount += thisAmount;
		}
		
		// add footer lines
		result.append("Amount owed is " + String.valueOf(totalAmount) + "\n");
		result.append("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
		
		return result.toString();
	}

	private int addBonusForNewRelease(int frequentRenterPoints, Rental each) {
		if ((each.getMovie() instanceof NewReleaseMovie) && each.getDaysRented() > 1) 
			frequentRenterPoints++;
		return frequentRenterPoints;
	}
}

package movierental;

public class StatementService {

	private StatementService() {

	}

	public static String buildStatement(Customer customer) {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String statementText = "Rental Record for " + customer.getName() + "\n";

		for (Rental each : customer.getRentals()) {
			frequentRenterPoints += each.getFrequentPointForRental();

			// show figures for this rental
			statementText += "\t" + each.getStatement();
			totalAmount += each.getPrice();
		}

		// add footer lines
		statementText += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		statementText += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

		return statementText;
	}

}

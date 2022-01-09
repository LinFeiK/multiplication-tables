package multiplications;

public class DisplayMultiplications {

	public static void main(String[] args) {
		
		// use for getting multiplications in a range (e.g., 1 to 5)
		// leftMin, leftMax, rightMin, rightMax
//		Multiplicator multiplicator = new Multiplicator(1, 12, 1, 12);
		// use for a subset of multiplications that doesn't fall into a range (e.g., 5 and 7)
		int[] leftSelections = {12, 15};
		Multiplicator multiplicator = new Multiplicator(leftSelections, 1, 12);
		multiplicator.shuffleOperations();
		multiplicator.printOperations(true);
		multiplicator.printOperationAnswers(true);
	}

}

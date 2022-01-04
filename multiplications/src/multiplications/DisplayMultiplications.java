package multiplications;

public class DisplayMultiplications {

	public static void main(String[] args) {
		
		// leftMin, leftMax, rightMin, rightMax
//		Multiplicator multiplicator = new Multiplicator(1, 12, 1, 12);
		int[] leftSelections = {4, 5, 11, 12};
		Multiplicator multiplicator = new Multiplicator(leftSelections, 1, 12);
		multiplicator.shuffleOperations();
		multiplicator.printOperations(true);
		multiplicator.printOperationAnswers(true);
	}

}

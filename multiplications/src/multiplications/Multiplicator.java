package multiplications;

import java.util.ArrayList;
import java.util.Random;

public class Multiplicator {
	
	private ArrayList<Integer> leftOperands;
	private ArrayList<Integer> rightOperands;
	private ArrayList<String> operations;
	private ArrayList<String> operationAnswers;
	
	// Left min/max: range of multiplication table numbers (inclusive)
	// Right min/max: what range of numbers the left numbers should be multiplied by (inclusive)
	public Multiplicator(int leftMin, int leftMax, int rightMin, int rightMax) {
		setUpLeftOperands(leftMin, leftMax);
		setUpRightOperands(rightMin, rightMax);
		setUpOperations();
	}
	
	// Use for specific multiplication tables that don't fall in a range
	public Multiplicator(int[] leftSelections, int rightMin, int rightMax) {
		setUpLeftOperands(leftSelections);
		setUpRightOperands(rightMin, rightMax);
		setUpOperations();
	}
	
	// Shuffle the operations so that they are not ordered
	public void shuffleOperations() {
		Random random = new Random();
		for (int i = operations.size() - 1; i >= 0; i--) {
			int randomInt = random.nextInt(i + 1);
			String temp = operations.get(randomInt);
			operations.set(randomInt, operations.get(i));
			operations.set(i, temp);
		}
		
		calculateResults();
	}
	
	public void printOperations(boolean isDisplayNumbers) {
		for (int i = 0; i < operations.size(); i++) {
			if (isDisplayNumbers) {
				System.out.print(i + 1 + ". ");
			}
			System.out.println(operations.get(i));
		}
	}
	
	public void printOperationAnswers(boolean isDisplayNumbers) {
		for (int i = 0; i < operationAnswers.size(); i++) {
			if (isDisplayNumbers) {
				System.out.print(i + 1 + ". ");
			}
			System.out.println(operationAnswers.get(i));
		}
	}
	
	// Use for a range of left operands
	private void setUpLeftOperands(int min, int max) {
		leftOperands = new ArrayList<>();
		
		for (int i = min; i <= max; i++) {
			leftOperands.add(i);
		}
	}
	
	// Use for a subset of left operands that don't fall into a range
	private void setUpLeftOperands(int[] selections) {
		leftOperands = new ArrayList<>();
		
		for (int i = 0; i < selections.length; i++) {
			leftOperands.add(selections[i]);
		}
	}
	
	private void setUpRightOperands(int min, int max) {		
		rightOperands = new ArrayList<>();
		
		for (int i = min; i <= max; i++) {
			rightOperands.add(i);
		}
	}
	
	// Populate operations given the left and right operands. Sample operation: "5 x 9 = "
	private void setUpOperations() {
		operations = new ArrayList<>();
		
		for (int i = 0; i < leftOperands.size(); i++) {
			for (int j = 0; j < rightOperands.size(); j++) {
				operations.add(leftOperands.get(i) + " x " + rightOperands.get(j) + " = ");
			}
		}
	}
	
	// Populate operationAnswers with the expressions and their answers
	private void calculateResults() {
		operationAnswers = new ArrayList<>();
		
		for (int i = 0; i < operations.size(); i++) {
			// sample operation: "5 x 7 = "
			String operation = operations.get(i);
			int operationIndex = operation.indexOf(" x");
			int equalSignIndex = operation.indexOf(" =");
			int leftOperand = Integer.parseInt(operation.substring(0, operationIndex));
			int rightOperand = Integer.parseInt(operation.substring(operationIndex + 3, equalSignIndex));
			
			// sample operationAnswer: "5 x 7 = 35"
			operationAnswers.add(operations.get(i) + leftOperand * rightOperand);
		}
	}
}

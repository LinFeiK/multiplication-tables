package multiplications;

import java.util.ArrayList;
import java.util.Random;

public class Multiplicator {
	
	private ArrayList<Integer> leftOperands;
	private ArrayList<Integer> rightOperands;
	private ArrayList<String> operations;
	private ArrayList<String> operationAnswers;
	
	public Multiplicator() {
		setUpOperands(1, 12);
		setUpOperations();
	}
	
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
	
	public void printOperations() {
		for (int i = 0; i < operations.size(); i++) {
			System.out.println(operations.get(i));
		}
	}
	
	public void printOperationAnswers() {
		for (int i = 0; i < operationAnswers.size(); i++) {
			System.out.println(operationAnswers.get(i));
		}
	}
	
	private void setUpOperands(int min, int max) {
		leftOperands = new ArrayList<>();
		for (int i = min; i <= max; i++) {
			leftOperands.add(i);
		}
		
		rightOperands = new ArrayList<>();
		for (int i = min; i <= max; i++) {
			rightOperands.add(i);
		}
	}
	
	private void setUpOperations() {
		operations = new ArrayList<>();
		
		for (int i = 0; i < leftOperands.size(); i++) {
			for (int j = 0; j < rightOperands.size(); j++) {
				operations.add(leftOperands.get(i) + " x " + rightOperands.get(j) + " = ");
			}
		}
	}
	
	private void calculateResults() {
		operationAnswers = new ArrayList<>();
		
		for (int i = 0; i < operations.size(); i++) {
			// sample operation: "n x m = "
			String operation = operations.get(i);
			int operationIndex = operation.indexOf(" x");
			int equalSignIndex = operation.indexOf(" =");
			int leftOperand = Integer.parseInt(operation.substring(0, operationIndex));
			int rightOperand = Integer.parseInt(operation.substring(operationIndex + 3, equalSignIndex));
			operationAnswers.add(operations.get(i) + leftOperand * rightOperand);
		}
	}
}

package multiplications;

import java.util.ArrayList;
import java.util.Random;

public class Calculator {
	
	private ArrayList<Integer> leftOperands;
	private ArrayList<Integer> rightOperands;
	private ArrayList<String> operations;
	private ArrayList<String> operationAnswers;
	
	public Calculator() {
		setUpOperands(1, 12);
		setUpOperations();
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
	
	public void shuffleOperations() {
		Random random = new Random();
		for (int i = operations.size() - 1; i >= 0; i--) {
			int randomInt = random.nextInt(i + 1);
			String temp = operations.get(randomInt);
			operations.set(randomInt, operations.get(i));
			operations.set(i, temp);
		}
		
	}
	
	public void printOperations() {
		for (int i = 0; i < operations.size(); i++) {
			System.out.println(operations.get(i));
		}
	}
	
}

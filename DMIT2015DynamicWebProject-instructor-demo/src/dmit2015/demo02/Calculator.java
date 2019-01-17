package dmit2015.demo02;

import javax.swing.JOptionPane;

public class Calculator {

	public static void main(String[] args) {
		// Prompt for math expression (ex. 3 + 5)
		String mathExpression = JOptionPane.showInputDialog("Enter a math expression (ex. 3 + 5)");

		// Extract operand1, operator, operand2 value from mathExpression
		// Assume operand1 and operand2 always contain a single digit number
		
		// Remove all whitespaces from mathExpression
		mathExpression = mathExpression.replaceAll(" ", "");
		int operand1 = Character.getNumericValue(mathExpression.charAt(0));
		char operator = mathExpression.charAt(1);
		int operand2 = Character.getNumericValue(mathExpression.charAt(2));
		
		// The result of the operation
		int result = 0;
		
		// Determine which operation to perform 
		// (+ for addition, - for subtraction, . for multiplication, / for division)
		// and calculate the result
		if (operator == '+') {
			result = operand1 + operand2;
		} else if (operator == '-') {
			result = operand1 - operand2;
		} else if (operator == '.') {
			result = operand1 * operand2;
		} else if (operator == '/') {
			result = operand1 / operand2;
		}
		
		String message = String.format("%d %s %d = %d", operand1, operator, operand2, result);
		//System.out.println(message);
		JOptionPane.showMessageDialog(null, message);
		
	}

}

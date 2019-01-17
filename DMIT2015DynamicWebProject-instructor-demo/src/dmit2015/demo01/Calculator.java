package dmit2015.demo01;

public class Calculator {

	public static void main(String[] args) {
		// Check the number of strings passed in
		// Exit program is number of arguments is not exactly 3
		if (args.length != 3) {
			System.out.println("Usage: Calculator operand1 operator operand2");
			System.exit(1);
		}

		int operand1 = Integer.parseInt( args[0] );
		char operator = args[1].charAt(0);
		int operand2 = Integer.parseInt( args[2] ); 
		
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
		
		// Display the result in the format: operand1 operator operand2 = result
		System.out.println(operand1 + " " + operator + " " + operand2 + " = " + result);
		String message = String.format("%d %s %d = %d", operand1, operator == '.' ? '*' : operator, operand2, result);
		System.out.println(message);
		
		
	}

}

package hello;

public class Expression {
	
	private static final String SPACE = " ";

	public static int rank(String op) {
		switch (op) {
		case "*":
		case "/":
			return 2;
		case "+":
		case "-":
			return 1;
		default:
			return -1;
		}
	}
	
	public static String toPostfix(String expr) {
		StringBuilder result = new StringBuilder();
		ArrayStack<String> operators = new ArrayStack<>();
		for (String token : expr.split("\\s+")) {
			if (rank(token) > 0) {
				while(!operators.isEmpty() && 
						rank(operators.peek()) >= rank(token)) {
					result.append(operators.pop() + SPACE);
				}
				operators.push(token);
			} else {
				result.append(token + SPACE);
			}
		}
		
		while (!operators.isEmpty()) {
			result.append(operators.pop() + SPACE);
		}
		return result.toString();
	}
	
	public static int applyOperator(String operator, int op1, int op2) {
		// TODO: implement me
		
		return 0;
	}
	
	public static int evalPostfix(String expr) {
		// TODO: implement me
		
		return 0;
	}

}

package kata6.model;

public class Calculator {
    public double calculate(String operation, double operand1, double operand2) {
        return switch (operation.toLowerCase()) {
            case "add" -> operand1 + operand2;
            case "subtract" -> operand1 - operand2;
            case "multiply" -> operand1 * operand2;
            case "divide" -> operand2 != 0 ? operand1 / operand2 : Double.NaN;
            default -> throw new IllegalArgumentException("Unsupported operation: " + operation);
        };
    }
}
package kata6.control.commands;

import kata6.control.Command;

public class CalculatorCommand implements Command {
    private final Input input;
    private final Output output;

    public CalculatorCommand(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() {
        double result = calculate();
        output.result(result);
    }

    private double calculate() {
        double operand1 = input.operand1();
        double operand2 = input.operand2();
        return switch (input.operation().toLowerCase()) {
            case "add" -> operand1 + operand2;
            case "subtract" -> operand1 - operand2;
            case "multiply" -> operand1 * operand2;
            case "divide" -> operand2 != 0 ? operand1 / operand2 : Double.NaN;
            default -> throw new IllegalArgumentException("Unsupported operation: " + input.operation());
        };
    }

    public interface Input {
        String operation();

        double operand1();

        double operand2();
    }

    public interface Output {
        void result(double result);
    }
}

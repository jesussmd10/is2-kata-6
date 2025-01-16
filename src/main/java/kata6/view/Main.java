import kata6.view.adapters.CalculatorRequestAdapter;
import  kata6.view.adapters.CalculatorResponseAdapter;
import  kata6.control.CommandFactory;
import  kata6.control.commands.CalculatorCommand;
import kata6.view.CalculatorService;

public class Main {

    public static void main(String[] args) {
        CommandFactory factory = new CommandFactory();
        factory.register("calculate", calculatorBuilder());
        new CalculatorService(8080, factory).start();
    }

    private static CommandFactory.Builder calculatorBuilder() {
        return (req, res) -> new CalculatorCommand(
                CalculatorRequestAdapter.from(req),
                CalculatorResponseAdapter.from(res)
        );
    }
}

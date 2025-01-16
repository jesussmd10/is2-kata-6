package kata6.view.adapters;


import kata6.control.commands.CalculatorCommand;

import jakarta.servlet.http.HttpServletRequest;

public class CalculatorRequestAdapter {
    public static CalculatorCommand.Input from(HttpServletRequest req) {
        return new CalculatorCommand.Input() {
            @Override
            public String operation() {
                return req.getParameter("operation");
            }

            @Override
            public double operand1() {
                return Double.parseDouble(req.getParameter("operand1"));
            }

            @Override
            public double operand2() {
                return Double.parseDouble(req.getParameter("operand2"));
            }
        };
    }
}

package kata6.view.adapters;

import kata6.control.commands.CalculatorCommand;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculatorResponseAdapter {
    public static CalculatorCommand.Output from(HttpServletResponse res) {
        return result -> {
            try {
                res.setContentType("application/json");
                res.getWriter().write("{\"result\": " + result + "}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}
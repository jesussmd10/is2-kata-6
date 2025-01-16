package kata6.view;

import kata6.control.CommandFactory;
import io.javalin.Javalin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kata6.view.adapters.Service;

public class CalculatorService implements Service {
    private final int port;
    private final CommandFactory factory;
    private Javalin app;

    public CalculatorService(int port, CommandFactory factory) {
        this.port = port;
        this.factory = factory;
    }

    public void start() {
        app = Javalin.create()
                .get("/calculate", ctx -> execute("calculate", ctx.req(), ctx.res()))
                .start(port);
    }

    private void execute(String command, HttpServletRequest req, HttpServletResponse res) {
        factory.with(req, res).build(command).execute();
    }

    public void stop() {
        app.stop();
    }
}
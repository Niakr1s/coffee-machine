package machine;

import machine.State.State;

import java.util.Scanner;

public class Runner {
    private static final Scanner in = new Scanner(System.in);

    private final Machine machine;

    public Runner(Machine machine) {
        this.machine = machine;
    }

    public void run() {
        while (true) {
            step();
        }
    }

    private void step() {
        State state = machine.getState();
        state.displayRequest();
        state.processCommand(getCommand());
        state.displayResponse();
        machine.toNextState();
    }

    private String getCommand() {
        if (!in.hasNext()) System.exit(0);
        return in.next();
    }
}

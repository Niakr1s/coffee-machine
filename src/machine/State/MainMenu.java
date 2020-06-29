package machine.State;

import com.sun.tools.javac.Main;
import machine.Machine;

public class MainMenu extends State {
    public MainMenu(Machine machine) {
        super(machine,
                "Write action (buy, fill, take, remaining, exit):");
    }

    @Override
    public void processCommand(String command) {
        switch (command) {
            case "buy":
                setNext(new Buy(getMachine()));
                break;
            case "fill":
                setNext(new Fill(getMachine()));
                break;
            case "take":
                int took = getMachine().takeAllMoney();
                setResponse(String.format("I gave you $%d", took));
                break;
            case "remaining":
                setResponse(getMachine().getStatus());
                break;
            case "exit":
                System.exit(0);
        }
    }
}

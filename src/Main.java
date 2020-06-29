import machine.Machine;
import machine.Runner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Machine machine = new Machine(400, 540, 120, 9, 550);
        Runner runner = new Runner(machine);
        runner.run();
    }
}

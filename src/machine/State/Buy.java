package machine.State;

import machine.CoffeeType;
import machine.Machine;

public class Buy extends State {
    Buy(Machine machine) {
        super(machine,
                "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
    }

    @Override
    public void processCommand(String command) {
        switch (command) {
            case "1":
                buyCoffee(CoffeeType.ESPRESSO);
                break;
            case "2":
                buyCoffee(CoffeeType.LATTE);
                break;
            case "3":
                buyCoffee(CoffeeType.CAPPUCCINO);
                break;
            case "back":
                goBack();
                break;
        }
    }

    private void goBack() {
        setNext(new MainMenu(getMachine()));
    }

    private void buyCoffee(CoffeeType type) {
        try {
            getMachine().buyOneCup(type);
            setResponse("I have enough resources, making you a coffee!");
        } catch (Machine.NotEnoughIngredients e) {
            setResponse(e.getMessage());
        } finally {
            setNext(new MainMenu(getMachine()));
        }
    }
}

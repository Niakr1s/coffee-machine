package machine;

import machine.State.MainMenu;
import machine.State.State;

public class Machine {
    private Resources storage;
    private final Money money;
    private State state;

    public Machine(int water, int milk, int beans, int cups, int money) {
        this.storage = new Resources(water, milk, beans, cups);
        this.money = new Money(money);
        this.state = new MainMenu(this);
    }

    public static class NotEnoughIngredients extends Exception {
        public NotEnoughIngredients(String message) {
            super(message);
        }
    }

    public void buyOneCup(CoffeeType type) throws NotEnoughIngredients, IllegalArgumentException {
        buy(type, 1);
    }

    public void buy(CoffeeType type, int cups) throws NotEnoughIngredients, IllegalArgumentException {
        if (cups < 0) {
            throw new IllegalArgumentException("Cups can't be negative");
        }
        Resources resourcesToSpend = type.getResources().multiply(cups);
        Resources newResources = storage.minus(resourcesToSpend);
        if (newResources.isLackingIngredients()) {
            throw new NotEnoughIngredients(String.format("Sorry, not enough %s",
                    String.join(", ", newResources.getLackingIngredients())));
        }
        storage = newResources;
        money.addMoney(type.getPrice());
    }

    public void fillStorage(Resources toAdd) {
        storage = storage.plus(toAdd);
    }

    public int takeAllMoney() {
        return money.takeAll();
    }

    public String getStatus() {
        return String.format("The coffee machine has:\n" +
                        "%d of water\n" +
                        "%d of milk\n" +
                        "%d of coffee beans\n" +
                        "%d of disposable cups\n" +
                        "$%d of money",
                storage.getWater(),
                storage.getMilk(),
                storage.getBeans(),
                storage.getCups(),
                money.getMoney()
        );
    }

    public State getState() {
        return state;
    }

    public void toNextState() {
        if (!state.hasNext()) return;
        state = state.next();
    }
}

package machine.State;

import machine.Machine;
import machine.Resources;

import java.util.Iterator;

public class Fill extends State {
    private Resources.Builder builder;
    private Stage stage = Stage.values()[0];

    private enum Stage implements Iterator {
        WATER("Write how many ml of water do you want to add:"),
        MILK("Write how many ml of milk do you want to add:"),
        BEANS("Write how many grams of coffee beans do you want to add:"),
        CUPS("Write how many disposable cups of coffee do you want to add:");

        private String request;

        Stage(String request) {
            this.request = request;
        }

        public String getRequest() {
            return request;
        }

        @Override
        public boolean hasNext() {
            return this.ordinal() < Stage.values().length - 1;
        }

        @Override
        public Stage next() {
            return Stage.values()[this.ordinal() + 1];
        }
    }

    public Fill(Machine machine) {
        super(machine);
        setRequest(stage.getRequest());
        this.builder = new Resources.Builder();
    }

    @Override
    public void processCommand(String command) {
        int amount = parseInt(command);
        switch (stage) {
            case WATER:
                builder.setWater(amount);
                break;
            case MILK:
                builder.setMilk(amount);
                break;
            case BEANS:
                builder.setBeans(amount);
                break;
            case CUPS:
                builder.setCups(amount);
                break;
            default:
                return;
        }
        if (stage.hasNext()) {
            stage = stage.next();
            setRequest(stage.getRequest());
            return;
        }
        getMachine().fillStorage(builder.build());
        setNext(new MainMenu(getMachine()));
    }
}

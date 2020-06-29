package machine.State;

import machine.Machine;

import java.util.Iterator;

public abstract class State implements Iterator<State> {
    private State nextState;
    private final Machine machine;

    private String response;
    private String request;

    State(Machine machine, String request) {
        this.machine = machine;
        this.request = request;
    }

    State(Machine machine) {
        this(machine, null);
    }

    public abstract void processCommand(String command) throws IllegalArgumentException;

    protected int parseInt(String str) throws IllegalArgumentException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void displayRequest() {
        if (request != null) {
            System.out.println();
            System.out.println(request);
        } ;
    }

    public void displayResponse() {
        if (response != null) {
            System.out.println(response);
            response = null;
        }
    }

    @Override
    public boolean hasNext() {
        return nextState != null;
    }

    @Override
    public State next() {
        return nextState;
    }

    protected void setNext(State nextState) {
        this.nextState = nextState;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}

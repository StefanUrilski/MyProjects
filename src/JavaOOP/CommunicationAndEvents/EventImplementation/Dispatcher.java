package JavaOOP.CommunicationAndEvents.EventImplementation;

import java.util.ArrayList;

public class Dispatcher {
    private String name;
    private ArrayList<NameChangeListener> observers;

    public Dispatcher() {
        this.name = "";
        this.observers = new ArrayList<>();
    }

    public void addNameChangeListener(NameChangeListener listener) {
        observers.add(listener);
    }

    public void removeNameChangeListener(NameChangeListener listener) {
        observers.remove(listener);
    }

    private void fireNameChangeEvent(Event event) {
        for (NameChangeListener listener : observers) {
            listener.handleChangedName(event);
        }
    }

    public void setName(String name) {
        this.name = name;
        Event event = new Event(this, this.name);

        this.fireNameChangeEvent(event);
    }

}

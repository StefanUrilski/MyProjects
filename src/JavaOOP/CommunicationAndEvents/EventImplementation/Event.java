package JavaOOP.CommunicationAndEvents.EventImplementation;

import java.util.EventObject;

public class Event extends EventObject {
    private String name;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public Event(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

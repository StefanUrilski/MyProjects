package JavaOOP.CommunicationAndEvents.EventImplementation;

public class Handler implements NameChangeListener{
    @Override
    public void handleChangedName(Event event) {
        System.out.println(String.format("Dispatcher's name changed to %s.", event.getName()));
    }
}

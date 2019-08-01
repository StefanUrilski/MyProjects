package JavaOOP.CommunicationAndEvents.KingGambit.models;

public class Footman extends GuardImpl {
    private static final int hitPoints = 2;

    public Footman(String name) {
        super(name, hitPoints);
    }

    @Override
    public void respondToKingsAttack() {
        System.out.println(String.format("Footman %s is panicking!", this.getName()));
    }
}

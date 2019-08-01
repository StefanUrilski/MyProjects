package JavaOOP.CommunicationAndEvents.KingGambit.models;

public class RoyalGuard extends GuardImpl {
    private static final int hitPoints = 3;

    public RoyalGuard(String name) {
        super(name, hitPoints);
    }

    @Override
    public void respondToKingsAttack() {
        System.out.println(String.format("Royal Guard %s is defending!", this.getName()));
    }
}

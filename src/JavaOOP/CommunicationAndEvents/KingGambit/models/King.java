package JavaOOP.CommunicationAndEvents.KingGambit.models;

import JavaOOP.CommunicationAndEvents.KingGambit.interfaces.Attackable;

public class King implements Attackable {
    private String name;
    private KingsGuard guard;

    public King(String name, KingsGuard guard) {
        this.name = name;
        this.guard = guard;
    }

    @Override
    public void underAttack() {
        System.out.println(String.format("King %s is under attack!", this.name));
        guard.respondToKingsAttack();
    }
}

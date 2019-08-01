package JavaOOP.CommunicationAndEvents.KingGambit.models;

import JavaOOP.CommunicationAndEvents.KingGambit.interfaces.Guard;

public abstract class GuardImpl implements Guard {
    private String name;
    private int hitPoints;

    public GuardImpl(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isDead() {
        hitPoints--;
        return hitPoints == 0;
    }

    @Override
    public void underAttack() {
        System.out.println(String.format("%s %s, staying still and looking pretty",
                this.getClass().getSimpleName(), name));
        // FIXME: 09-Apr-19 it's should call method is dead...
    }
}

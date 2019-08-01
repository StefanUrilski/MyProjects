package JavaOOP.CommunicationAndEvents.KingGambit.interfaces;

public interface Killable extends Attackable {
    boolean isDead();
    void respondToKingsAttack();
}

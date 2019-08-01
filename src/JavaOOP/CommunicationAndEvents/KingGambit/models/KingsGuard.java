package JavaOOP.CommunicationAndEvents.KingGambit.models;

import JavaOOP.CommunicationAndEvents.KingGambit.interfaces.Guard;

import java.util.LinkedHashMap;
import java.util.Map;

public class KingsGuard {
    private Map<String, Guard> royalGuard;
    private Map<String, Guard> footman;

    public KingsGuard() {
        this.royalGuard = new LinkedHashMap<>();
        this.footman = new LinkedHashMap<>();
    }

    public void addRoyalGuards(String[] guard) {
        for (String guardian : guard) {
            RoyalGuard royalGuard = new RoyalGuard(guardian);
            this.royalGuard.put(guardian, royalGuard);
        }
    }

    public void addFootman(String[] guard) {
        for (String guardian : guard) {
            Footman footman = new Footman(guardian);
            this.footman.put(guardian, footman);
        }
    }

    public void attackGuard(String name) {
        if (footman.containsKey(name)) {
            if (footman.get(name).isDead()) {
                footman.remove(name);
            }
        } else if (royalGuard.containsKey(name)) {
            if (royalGuard.get(name).isDead()) {
                royalGuard.remove(name);
            }
        }
    }

    void respondToKingsAttack() {
        for (Guard guard : royalGuard.values()) {
            guard.respondToKingsAttack();
        }

        for (Guard footman : footman.values()) {
            footman.respondToKingsAttack();
        }
    }
}

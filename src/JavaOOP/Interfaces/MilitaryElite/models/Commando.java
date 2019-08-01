package JavaOOP.Interfaces.MilitaryElite.models;

import JavaOOP.Interfaces.MilitaryElite.common.Mission;

import java.util.ArrayList;
import java.util.List;

public class Commando extends SpecialisedSoldier {
    private final static String[] STATE = {"inProgress", "Finished", };
    private List<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    public void addMissions(String name, String state) {
        if (! (Commando.STATE[0].equals(state) || Commando.STATE[1].equals(state))) {
            return;
        }
        Mission mission = new Mission(name, state);
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());

        sb.append("Missions:");

        if (! this.missions.isEmpty()) {
            sb.append((System.lineSeparator()));
        }

        for (int i = 0; i < this.missions.size(); i++) {
            if (i == this.missions.size() - 1) {
                sb.append("  ").append(this.missions.get(i));
            } else {
                sb.append("  ").append(this.missions.get(i)).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}

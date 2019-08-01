package JavaOOP.Interfaces.MilitaryElite.models;

import JavaOOP.Interfaces.MilitaryElite.common.Repair;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends SpecialisedSoldier {
    private List<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    public void addPartAndHoursWorked(String part, int hours) {
        Repair repair = new Repair(part, hours);
        repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());

        sb.append("Repairs:");

        if (! this.repairs.isEmpty()) {
            sb.append((System.lineSeparator()));
        }

        for (int i = 0; i < this.repairs.size(); i++) {
            if (i == this.repairs.size() - 1) {
                sb.append("  ").append(this.repairs.get(i));
            } else {
                sb.append("  ").append(this.repairs.get(i)).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}

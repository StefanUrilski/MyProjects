package JavaOOP.Interfaces.MilitaryElite.models;

import JavaOOP.Interfaces.MilitaryElite.contracts.Soldier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeutenantGeneral  extends Private {
    private List<Soldier> company;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.company = new ArrayList<>();
    }

    public void addPrivates(Soldier privateSoldier) {
        company.add(privateSoldier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());

        sb.append("Privates:");

        if (! this.company.isEmpty()) {
            sb.append((System.lineSeparator()));
        }

        List<Soldier> sortedCompany = this.company.stream().sorted((f, s) -> Integer.compare(s.getId(), f.getId()))
                .collect(Collectors.toList());

        for (int i = 0; i < sortedCompany.size(); i++) {
            if (i == sortedCompany.size() - 1) {
                sb.append("  ").append(sortedCompany.get(i).toString());
            } else {
                sb.append("  ").append(sortedCompany.get(i).toString()).append(System.lineSeparator());
            }
        }


        return sb.toString();
    }
}

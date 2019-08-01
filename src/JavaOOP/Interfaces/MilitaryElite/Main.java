package JavaOOP.Interfaces.MilitaryElite;

import JavaOOP.Interfaces.MilitaryElite.contracts.Soldier;
import JavaOOP.Interfaces.MilitaryElite.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<Integer, Soldier> army = new LinkedHashMap<>();

        String line = reader.readLine();
        while(!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String cmd = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            Soldier soldier = null;

            if (cmd.equals("Private")) {
                soldier = new Private(id, firstName, lastName, Double.parseDouble(tokens[4]));
                army.put(id, soldier);
            } else if (cmd.equals("LeutenantGeneral")) {
                soldier = new LeutenantGeneral(id, firstName, lastName, Double.parseDouble(tokens[4]));
                List<Integer> privates = Arrays.stream(tokens).skip(5).map(Integer::parseInt).collect(Collectors.toList());

                for (Integer aPrivate : privates) {
                    ((LeutenantGeneral) soldier).addPrivates(army.get(aPrivate));
                }

                army.put(id, soldier);
            } else if (cmd.equals("Engineer")) {
                String corps = tokens[5];
                if (corps.equals("Airforces") || corps.equals("Marines")) {
                    soldier = new Engineer(id, firstName, lastName, Double.parseDouble(tokens[4]), corps);
                    String[] work = Arrays.stream(tokens).skip(6).toArray(String[]::new);

                    for (int i = 0; i < work.length; i += 2) {
                        String currWork = work[i];
                        int hours = Integer.parseInt(work[i + 1]);
                        ((Engineer) soldier).addPartAndHoursWorked(currWork, hours);
                    }

                    army.put(id, soldier);
                }
            } else if (cmd.equals("Commando")) {
                String corps = tokens[5];
                if (corps.equals("Airforces") || corps.equals("Marines")) {
                    soldier = new Commando(id, firstName, lastName, Double.parseDouble(tokens[4]), corps);
                    String[] missions = Arrays.stream(tokens).skip(6).toArray(String[]::new);

                    for (int i = 0; i < missions.length; i += 2) {
                        String name = missions[i];
                        String state = missions[i + 1];
                        ((Commando) soldier).addMissions(name, state);
                    }

                    army.put(id, soldier);
                }
            } else if (cmd.equals("Spy")) {
                soldier = new Spy(id, firstName, lastName, tokens[4]);
                army.put(id, soldier);
            }

            line = reader.readLine();
        }

        army.values().forEach(System.out::println);

    }
}

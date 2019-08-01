package Exam.ExamPreparation.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> stats = new LinkedHashMap<>();

        String line = reader.readLine();

        while (!line.equals("Season End")) {
            String[] tokens = line.split(" - ");
            String[] parts = tokens[1].split("\\s+");
            String homeTeam = tokens[0];
            String homeResult = parts[2];
            String guestTeam = parts[0];
            String guestResult = calcGuestResult(homeResult);

            stats.putIfAbsent(homeTeam, new LinkedList<>());
            stats.get(homeTeam).add(guestTeam + " -> " + homeResult);

            stats.putIfAbsent(guestTeam, new LinkedList<>());
            stats.get(guestTeam).add(homeTeam + " -> " + guestResult);
            line = reader.readLine();
        }

        String[] tokens = reader.readLine().split(", ");

        for (String name : tokens) {
            if (stats.containsKey(name)) {
                stats.get(name).sort(Comparator.comparing(f -> f.substring(0, f.indexOf(" "))));
                for (String guest : stats.get(name)) {
                    System.out.println(name + " - " + guest);
                }
            }
        }

    }

    private static String calcGuestResult(String homeResult) {
        String[] tokens = homeResult.split(":");
        return tokens[1] + ":" + tokens[0];
    }
}

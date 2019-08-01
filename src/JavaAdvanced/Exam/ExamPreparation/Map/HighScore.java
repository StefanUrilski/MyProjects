package Exam.ExamPreparation.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class HighScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Long> totalScore = new LinkedHashMap<>();
        LinkedHashMap<String, List<String>> battleScore = new LinkedHashMap<>();

        String line;

        while (! "osu!".equals(line = reader.readLine())) {
            String[] tokens = line.split("<->|\\s+");

            String firstName = tokens[1];
            int firstScore = Integer.valueOf(tokens[0]);
            String secondName = tokens[2];
            int secondScore = Integer.valueOf(tokens[3]);

            int first = firstScore - secondScore;
            int second = secondScore - firstScore;

            totalScore.putIfAbsent(firstName, 0L);
            totalScore.putIfAbsent(secondName, 0L);
            battleScore.putIfAbsent(firstName, new LinkedList<>());
            battleScore.putIfAbsent(secondName, new LinkedList<>());

            totalScore.put(firstName, totalScore.get(firstName) + first);
            battleScore.get(firstName).add(secondName + " <-> " + first);

            totalScore.put(secondName, totalScore.get(secondName) + second);
            battleScore.get(secondName).add(firstName + " <-> " + second);
        }

        totalScore.entrySet().stream().sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                .forEach(p -> {
                    System.out.println(p.getKey() + " - (" + p.getValue() + ")");
                    battleScore.get(p.getKey()).forEach(e -> System.out.println("*   " + e));
                });
    }
}

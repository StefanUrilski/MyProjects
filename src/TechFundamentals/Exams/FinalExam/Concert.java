package Exams.FinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Concert {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> bandName = new LinkedHashMap<>();
        Map<String, Integer> playBandTime = new LinkedHashMap<>();

        int totalTime = 0;
        String input;
        while (! "start of concert".equals(input = reader.readLine())) {
            if (input.contains("Add")) {
                String[] tokens = input.split("; ");
                if (tokens.length == 2) {
                    continue;
                }
                String name = tokens[1];
                playBandTime.putIfAbsent(name, 0);
                bandName.putIfAbsent(name, new ArrayList<>());
                String[] members = tokens[2].split(", ");
                for (String member : members) {
                    if (! bandName.get(name).contains(member)) {
                        bandName.get(name).add(member);
                    }
                }
            }
            if (input.contains("Play")) {
                String[] tokens = input.split("; ");
                if (tokens.length == 2) {
                    int time = Integer.valueOf(tokens[1]);
                    playBandTime.put(" ", time);
                    totalTime += time;
                    continue;
                }
                String name = tokens[1];
                playBandTime.putIfAbsent(name, 0);
                int time = Integer.valueOf(tokens[2]);
                playBandTime.put(name, playBandTime.get(name) + time);
                totalTime += time;
            }
        }
        System.out.println("Total time: " + totalTime);
        playBandTime.entrySet().stream().sorted((e1, e2) -> {
            if (e2.getValue().equals(e1.getValue())) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return Integer.compare(e2.getValue(), e1.getValue());
        }).forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

        input = reader.readLine();
        System.out.println(input);
        for (Map.Entry<String, List<String>> entry : bandName.entrySet()) {
            if (entry.getKey().equals(input)) {
                for (String value : entry.getValue()) {
                    System.out.println("=> " + value);
                }

            }
        }
    }
}

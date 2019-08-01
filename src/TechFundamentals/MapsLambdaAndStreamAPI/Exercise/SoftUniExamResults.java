package MapsLambdaAndStreamAPI.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SoftUniExamResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> results = new LinkedHashMap<>();
        Map<String, Integer> languageCount = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!input.equals("exam finished")) {
            String[] tokens = input.split("-");
            String student = tokens[0];
            String language = tokens[1];
            if (language.equals("banned")) {
                results.remove(student);
                input = reader.readLine();
                continue;
            }
            int points = Integer.valueOf(tokens[2]);

            results.putIfAbsent(student, 0);
            if (points > results.get(student)) {
                results.put(student, points);
            }
            languageCount.putIfAbsent(language, 0);
            languageCount.put(language, languageCount.get(language) + 1);
            input = reader.readLine();
        }
        System.out.println("Results:");
        results.entrySet().stream().sorted((e1, e2) -> {
            if (e2.getValue().equals(e1.getValue())) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return Integer.compare(e2.getValue(), e1.getValue());
        }).forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));
        System.out.println("Submissions:");
        languageCount.entrySet().stream().sorted((x1, x2) -> {
            if (x1.getValue().equals(x2.getValue())) {
                return x1.getKey().compareTo(x2.getKey());
            }
            return Integer.compare(x2.getValue(),x1.getValue());
        }).forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

    }
}

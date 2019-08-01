package MapsLambdaAndStreamAPI.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Double>> journal = new LinkedHashMap<>();
        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            Double grade = Double.valueOf(reader.readLine());
            if (!journal.containsKey(name)) {
                journal.put(name, new ArrayList<>());
            }
            journal.get(name).add(grade);
        }
        Map<String, Double> namesAndGrades = new LinkedHashMap<>();
        for (String names : journal.keySet()) {
            double sum = 0;
            for (int i = 0; i < journal.get(names).size(); i++) {
                sum += journal.get(names).get(i);
            }
            double average = sum / journal.get(names).size();

            if (average >= 4.50) {
                namesAndGrades.put(names, average);
            }
        }
        namesAndGrades.entrySet().stream()
                .sorted((d1, d2) -> d2.getValue().compareTo(d1.getValue()))
                //.sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(e -> System.out.println(String.format("%s -> %.2f",
                        e.getKey(), e.getValue())));
    }
}

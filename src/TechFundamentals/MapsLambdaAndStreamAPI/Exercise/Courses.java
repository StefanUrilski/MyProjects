package TechFundamentals.MapsLambdaAndStreamAPI.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Courses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String inputLine = reader.readLine();
        while (!inputLine.equals("end")) {
            String[] input = inputLine.split(" : ");
            String currCourse = input[0];
            String name = input[1];

            if (!courses.containsKey(currCourse)) {
                courses.put(currCourse, new ArrayList<>());
            }
            // May be a wrong answer in judge because that if...
            if (!courses.containsValue(name)) {
                courses.get(currCourse).add(name);
            }
            inputLine = reader.readLine();
        }
        courses.entrySet().stream()
                .sorted((e1, e2) -> {
                    int x1 = e1.getValue().size();
                    int x2 = e2.getValue().size();
                    return Integer.compare(x2, x1);
                })
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    Collections.sort(e.getValue());
                    for (String names : e.getValue()) {
                        System.out.println("-- " + names);
                    }
                });
        /*
        .forEach(a -> {
                // Printing the course
                System.out.println(a.getKey() + ": " + a.getValue().getRows());
                // Streaming and sorting
                a.getValue().stream().sorted()
                .forEach(c -> System.out.println("-- "+ c));
        });
         */

    }
}

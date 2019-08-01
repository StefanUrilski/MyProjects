package Exam.ExamPreparation.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.ToLongFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, HashMap<String, Long>> data = new HashMap<>();

        String line = reader.readLine();
        Pattern pattern = Pattern.compile("Grow <[A-z][a-z]+> <[A-Za-z0-9]+> [0-9]+");
        while(!line.equals("Icarus, Ignite!")) {
            Matcher matcher = pattern.matcher(line);
            if (! matcher.matches()) {
                line = reader.readLine();
                continue;
            }
            line = line.replaceAll("[<>]+", "");
            String[] tokens = Arrays.stream(line.split("\\s+")).skip(1).toArray(String[]:: new);
            String region = tokens[0];
            String color = tokens[1];
            int size = Integer.valueOf(tokens[2]);

            data.putIfAbsent(region, new HashMap<>());

            data.get(region).putIfAbsent(color, 0L);

            data.get(region).put(color, data.get(region).get(color) + size);

            line = reader.readLine();
        }

        data.entrySet().stream()
                .sorted((f, s) -> {
                    int result = Long.compare(s.getValue().values().stream().mapToLong(x -> x).sum(),
                            f.getValue().values().stream().mapToLong(x -> x).sum());
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                }).forEach(region -> {
                    System.out.println(region.getKey());
                    region.getValue().entrySet().stream()
                            .sorted(Comparator.comparingLong((ToLongFunction<Map.Entry<String, Long>>) Map.Entry::getValue)
                                    .thenComparing(Map.Entry::getKey))
                            .forEach((c) -> System.out.printf("*--%s | %d%n", c.getKey(), c.getValue()));
                });
    }
}

package Regex.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racers = new LinkedHashMap<>();
        String nameRegex = "[^A-Za-z]+";
        String distanceRegex = "[^\\d]+";

        String input = reader.readLine();

        while (!input.contains("end of race")) {
            Pattern pattern = Pattern.compile(nameRegex);
            Matcher matcher = pattern.matcher(input);
            String name = matcher.replaceAll("");
            if (names.contains(name)) {
                pattern = Pattern.compile(distanceRegex);
                matcher = pattern.matcher(input);
                String distance = matcher.replaceAll("");
                int distanceSum = 0;
                for (int i = 0; i < distance.length(); i++) {
                    distanceSum += distance.charAt(i) - 48;
                }
                racers.putIfAbsent(name, 0);
                int temp = racers.get(name);
                racers.put(name, temp + distanceSum);
            }
            input = reader.readLine();
        }
        List<String> result = new ArrayList<>();
        racers.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue())
                .limit(3)
                .forEach(entry -> result.add(entry.getKey()));
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    System.out.printf("1st place: %s%n", result.get(i));
                    break;
                case 1:
                    System.out.printf("2nd place: %s%n", result.get(i));
                    break;
                case 2:
                    System.out.printf("3rd place: %s%n", result.get(i));
                    break;
            }
        }

    }
}

package OtherCourses.SetsAndMaps.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CountSameValuesInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> counter = new HashMap<>();

        String[] numbers = reader.readLine().split("\\s+");

        for (String number : numbers) {
            counter.putIfAbsent(number, 0);
            counter.put(number, counter.get(number) + 1);
        }

        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " times");
        }

    }
}

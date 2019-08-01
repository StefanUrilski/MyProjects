package SetsAndMaps.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tokens = reader.readLine();

        Map<Character, Integer> counter = new TreeMap<>();
        for (int i = 0; i < tokens.length(); i++) {
            char curr = tokens.charAt(i);
            counter.putIfAbsent(curr, 0);
            counter.put(curr, counter.get(curr) + 1);
        }
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            System.out.println(String.format("%s: %d time/s", entry.getKey(), entry.getValue()));
        }
    }
}

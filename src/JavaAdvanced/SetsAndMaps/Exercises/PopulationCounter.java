package SetsAndMaps.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, LinkedHashMap<String, Integer>> populationMap = new HashMap<>();

        String input = reader.readLine();

        while (! input.equals("report")) {

            String[] tokens = input.split("\\|");
            String country = tokens[1];
            String city = tokens[0];
            int population = Integer.valueOf(tokens[2]);

            populationMap.putIfAbsent(country, new LinkedHashMap<>());
            populationMap.get(country).putIfAbsent(city, 0);
            populationMap.get(country).put(city, populationMap.get(country).get(city) + population);

            input = reader.readLine();
        }

        /*
        TODO ..... system out !
         */
    }
}

package SetsAndMaps.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.valueOf(reader.readLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < lines; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            elements.addAll(Arrays.asList(tokens));
        }
        for (String element : elements) {
            System.out.print(element + " ");
        }


    }
}

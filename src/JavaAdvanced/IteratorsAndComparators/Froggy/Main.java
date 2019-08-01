package IteratorsAndComparators.Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] spots = Arrays.stream(reader.readLine().split("[,\\s]+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        if (spots.length == 1) {
            System.out.println(spots[0]);
            return;
        }

        Lake<Integer> lake = new Lake<>(spots);

        List<String> result = new ArrayList<>();

        for (Integer indexes : lake) {
            result.add(String.valueOf(indexes));
        }

        System.out.println(String.join(", " , result));
    }
}

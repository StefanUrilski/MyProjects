package Generics.Exercises.FromOneToSeven.FirstToFourth;


import Generics.Exercises.FromOneToSeven.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        List<Box> list = new ArrayList<>();

        while (n-- > 0) {
            String line = reader.readLine();

            Box box = null;
            try {
                int numb = Integer.valueOf(line);
                box = new Box<>(numb);
                list.add(box);

            } catch (Exception e) {
                box = new Box<>(line);
                list.add(box);
            }
        }

        int[] indexes = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        swapValues(list, indexes);

        list.forEach(System.out::println);
    }

    private static void swapValues(List<Box> list, int[] indexes) {
        Box temp = list.get(indexes[0]);
        list.set(indexes[0], list.get(indexes[1]));
        list.set(indexes[1], temp);
    }
}

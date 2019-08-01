package Algorithms.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GeneratingCombinations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .toArray();

        int border = Integer.valueOf(reader.readLine());
        int[] vector = new int[border];
        Combinations(numbers, vector, 0, -1);
    }

    private static void Combinations(int[] numbers, int[] vector, int index, int border) {

        if (index >= vector.length) {
            Arrays.stream(vector).forEach(e -> System.out.print(e + " "));
            System.out.println();
        } else {
            for (int i = border + 1; i < numbers.length; i++) {
                vector[index] = numbers[i];
                Combinations(numbers, vector, index + 1, i);
            }
        }

    }
}

package Algorithms.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CombinationsWithRepetition {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int elements = Integer.valueOf(reader.readLine());
        int column = Integer.valueOf(reader.readLine());

        int[] arr = new int[column];

        printTheSequence(arr, elements , 0, 0);

    }

    private static void printTheSequence(int[] arr, int elements, int column, int currElement) {

        if (currElement == arr.length) {
            Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
            System.out.println();
            return;
        }


        for (int i = 1 + column; i <= elements; i++) {
            arr[currElement] = i;
            printTheSequence(arr, elements, column, currElement + 1);
            column++;
        }
    }
}

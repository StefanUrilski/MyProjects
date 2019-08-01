package Algorithms.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbs = reader.readLine().split("\\s+");

        printingArrayInReverse(numbs, 0);
    }

    private static void printingArrayInReverse(String[] numbs, int index) {

        if (index == numbs.length) {
            return;
        }

        printingArrayInReverse(numbs, index + 1);

        System.out.print(numbs[index] + " ");
    }
}

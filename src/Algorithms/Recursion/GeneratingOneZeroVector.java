package Algorithms.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GeneratingOneZeroVector {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        int[] nums = new int[n];

        print(nums, 0);
    }

    private static void print(int[] arr, int index) {

        if (index == arr.length) {
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println();
        } else {
            for (int i = 0; i <= 1; i++) {
                arr[index] = i;
                print(arr, index + 1);
            }
        }
    }
}

package TechFundamentals.OtherCourses.Lists.Exerscise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TripleSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean match = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                boolean hasFound = contains(arr, sum);
                if (hasFound) {
                    System.out.printf("%d + %d == %d%n", arr[i], arr[j], sum);
                    match = true;
                }
            }
        }
        if (!match) {
            System.out.println("No");
        }
    }

    private static boolean contains(int[] arr, int sum) {
        for (int num : arr) {
            if (num == sum) {
                return true;
            }
        }
        return false;
    }
}

package TechFundamentals.OtherCourses.Lists.Exerscise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastK_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int k = Integer.valueOf(reader.readLine());
        int[] numbers = new int[n];
        numbers[0] = 1;

        for (int i = 0; i < n; i++) {
            if (i < k) {
                for (int j = 0; j < i; j++) {
                    numbers[i] += numbers[j];
                }
            } else {
                for (int j = 0; j < k; j++) {
                    numbers[i] += numbers[i - k + j];
                }
            }
        }
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}

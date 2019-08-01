package TechFundamentals.OtherCourses.Lists.Exerscise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastK_NumbersBetter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int k = Integer.valueOf(reader.readLine());

        long[] numbers = new long[n];
        numbers[0] = 1;
        for (int currentIndex = 0; currentIndex < n; currentIndex++) {
            int startIndex = Math.max(0, currentIndex - k);
            long sum = 0;
            for (int j = startIndex; j <= currentIndex; j++) {
                sum += numbers[j];
            }
            numbers[currentIndex] = sum;
            System.out.print(numbers[currentIndex] + " ");
        }

    }
}

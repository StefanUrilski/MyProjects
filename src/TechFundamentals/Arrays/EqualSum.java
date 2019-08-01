package TechFundamentals.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EqualSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbers.length; i++) {
            int leftIndexSum = 0;
            int rightIndexSum = 0;
            for (int j = 0; j < i; j++) {
                leftIndexSum += numbers[j];
            }
            for (int j = i + 1; j < numbers.length; j++) {
                rightIndexSum += numbers[j];
            }
            if (leftIndexSum == rightIndexSum) {
                System.out.print(i);
                return;
            }
        }
        System.out.println("no");

    }
}

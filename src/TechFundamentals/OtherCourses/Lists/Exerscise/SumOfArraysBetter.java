package TechFundamentals.OtherCourses.Lists.Exerscise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfArraysBetter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] num1 = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] num2 = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxLength = Math.max(num1.length, num2.length);
        int sum = 0;
        for (int i = 0; i < maxLength; i++) {
            if (num1.length > num2.length){
                sum = num1[i] + num2[i % num2.length];
                System.out.print(sum + " ");
            } else if (num1.length < num2.length){
                sum = num2[i] + num1[i % num1.length];
                System.out.print(sum + " ");
            } else {
                sum = num2[i] + num1[i];
                System.out.print(sum + " ");
            }
        }

    }
}

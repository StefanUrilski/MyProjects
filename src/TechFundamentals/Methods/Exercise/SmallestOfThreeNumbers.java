package TechFundamentals.Methods.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.valueOf(reader.readLine());
        int second = Integer.valueOf(reader.readLine());
        int third = Integer.valueOf(reader.readLine());

        foundingTheSmallest(first, second, third);

    }

    private static void foundingTheSmallest(int first, int second, int third) {
        if (first < second && first < third) {
            System.out.println(first);
        } else if (second < first && second < third) {
            System.out.println(second);
        } else {
            System.out.println(third);
        }
    }
}

package TechFundamentals.Methods.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddAndSubtract {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.valueOf(reader.readLine());
        int second = Integer.valueOf(reader.readLine());
        int third = Integer.valueOf(reader.readLine());

        System.out.println(subtractNumbers(first, second, third));
    }

    private static int sumNumbers(int first, int second) {
        return first + second;
    }
    private static int subtractNumbers(int first, int second, int third) {
        return sumNumbers(first, second) - third;
    }
}

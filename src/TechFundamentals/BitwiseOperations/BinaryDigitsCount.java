package TechFundamentals.BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryDigitsCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.valueOf(reader.readLine());
        int digit = Integer.valueOf(reader.readLine());

        String binary = Integer.toString(inputNumber, 2);
        int contains = 0;
        int number = Integer.valueOf(binary);
        for (int i = 0; i < binary.length(); i++) {
            int temp = number % 10;
            number /= 10;
            if (temp == digit) {
                contains++;
            }
        }
        System.out.println(contains);
    }
}

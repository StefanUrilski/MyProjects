package TechFundamentals.Methods.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        int n = Integer.valueOf(number);

        checkNumberAndPrint(n, number.length());
    }

    private static void checkNumberAndPrint (int end, int length) {
        for (int i = 16; i < end; i++) {
            if (numberDivisibleByEight(i, length)) {
                if (findingOddDigit(i)) {
                    System.out.println(i);
                }
            }

        }
    }
    private static boolean numberDivisibleByEight(int num, int length) {
        int sumDigits = 0;
        for (int i = 0; i < length; i++) {
            int temp = num % 10;
            sumDigits += temp;
            num = num / 10;
        }
        return sumDigits % 8 == 0;
    }
    private static boolean findingOddDigit(int index) {
        String numberLength = String.valueOf(index);
        for (int i = 0; i < numberLength.length(); i++) {
            int temp = index % 10;
            if (temp % 2 != 0) {
                return true;
            }
            index = index / 10;
        }
        return false;
    }
}

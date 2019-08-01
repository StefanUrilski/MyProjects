package TechFundamentals.Methods.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (!input.equals("END")) {
            if (palindromeCheck(input)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            input = reader.readLine();
        }

    }

    private static boolean palindromeCheck(String input) {
        return input.charAt(0) == input.charAt(input.length() - 1);
    }
}

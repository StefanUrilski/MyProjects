package TechFundamentals.StringsAndTextProcessing.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitsLettersOther {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String randomInput = reader.readLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder other = new StringBuilder();
        for (int i = 0; i < randomInput.length(); i++) {
            char curr = randomInput.charAt(i);
            if (Character.isDigit(curr)) {
                digits.append(curr);
            } else if (Character.isAlphabetic(curr)) {
                letters.append(curr);
            } else {
                other.append(curr);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(other);
    }
}

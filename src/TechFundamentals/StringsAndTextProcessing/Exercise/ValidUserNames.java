package TechFundamentals.StringsAndTextProcessing.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidUserNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] users = reader.readLine().split(", ");

        for (String curr : users) {
            if (curr.length() > 2 && curr.length() < 17) {
                if (checkIfContainsLettersOrDigits(curr)) {
                    System.out.println(curr);
                }
            }
        }

    }

    private static boolean checkIfContainsLettersOrDigits(String word) {
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (!(Character.isLetterOrDigit(curr) || curr == '-' || curr ==  '_')) {
                return false;
            }
        }
        return true;
    }
}

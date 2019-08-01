package TechFundamentals.Methods.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordValidator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String password = reader.readLine();
        checkingPassword(password);

    }

    private static void checkingPassword(String word) {
        if (checkingLength(word) && checkingContains(word) && checkingDigits(word)) {
            System.out.println("Password is valid");
        } else {
            if (!checkingLength(word)) {
                System.out.println("Password must be between 6 and 10 characters");
            }
            if (!checkingContains(word)) {
                System.out.println("Password must consist only of letters and digits");
            }
            if (!checkingDigits(word)) {
                System.out.println("Password must have at least 2 digits");
            }
        }
    }

    private static boolean checkingLength(String word) {
        if (word.length() < 6 || word.length() > 10) {
            return false;
        }
        return true;
    }

    private static boolean checkingContains(String word) {
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            if (!(temp < 'a' || temp > 'z') || !(temp < '0' || temp > '9') ||
                    !(temp < 'A' || temp > 'Z')) {
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean checkingDigits(String word) {
        int countDigits = 0;
        for (int i = 0; i < word.length(); i++) {
            if (!(word.charAt(i) < '0' || word.charAt(i) > '9')) {
                countDigits++;
            }
        }
        if (countDigits < 2) {
            return false;
        }
        return true;
    }
}

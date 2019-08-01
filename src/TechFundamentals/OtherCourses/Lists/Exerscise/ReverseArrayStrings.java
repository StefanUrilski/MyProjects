package TechFundamentals.OtherCourses.Lists.Exerscise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArrayStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] letters = input.split(" ");

        reverse(letters);
        System.out.print(print(letters));

    }

    private static String print(String[] letters) {
        String result = "";
        for (String letter : letters) {
            result += (letter + " ");
        }
        return result.trim();
    }

    private static void reverse(String[] letters) {
        for (int i = 0; i < letters.length / 2; i++) {
            String x = letters[i];
            letters[i] = letters[letters.length - 1 - i];
            letters[letters.length - 1 - i] = x;
        }
    }
}

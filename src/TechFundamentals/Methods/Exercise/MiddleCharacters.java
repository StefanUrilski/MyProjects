package TechFundamentals.Methods.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiddleCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String  input = reader.readLine();

        System.out.println(findMiddle(input));
    }

    private static String findMiddle(String word) {
        String result = "";
        if (word.length() < 3) {
            return word;
        }
        int middle = word.length() / 2;
        if (word.length() % 2 == 0) {
            for (int i = middle - 1; i <= middle; i++) {
                result += word.charAt(i);
            }
        } else {
            for (int i = middle; i <= middle; i++) {
                result += word.charAt(i);
            }
        }
        return result;
    }
}

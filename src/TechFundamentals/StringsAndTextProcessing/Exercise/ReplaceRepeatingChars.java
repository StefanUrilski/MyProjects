package TechFundamentals.StringsAndTextProcessing.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceRepeatingChars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder result = new StringBuilder();
        result.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (input.charAt(i - 1) != input.charAt(i)) {
                result.append(curr);
            }
        }
        System.out.println(result);
    }
}

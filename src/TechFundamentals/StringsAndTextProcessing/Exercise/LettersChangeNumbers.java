package TechFundamentals.StringsAndTextProcessing.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        double sum = 0;
        for (String anInput : input) {
            String[] tokens = anInput.split("\\d+");
            char firstChar = tokens[0].charAt(0);
            char secondChar = tokens[1].charAt(0);
            double number = Integer.parseInt(anInput.substring(1, anInput.length() - 1));
            int firstNumb = charPositionFromAlphabet(firstChar);
            int secondNumb = charPositionFromAlphabet(secondChar);
            double result = 0;
            if (Character.isUpperCase(firstChar)) {
                result += number / firstNumb;
            } else if (Character.isLowerCase(firstChar)) {
                result += number * firstNumb;
            }
            if (Character.isUpperCase(secondChar)) {
                result -= secondNumb;
            } else if (Character.isLowerCase(secondChar)) {
                result += secondNumb;
            }
            sum += result;
        }
        System.out.println(String.format("%.2f", sum));

    }

    private static int charPositionFromAlphabet(char curr) {
        if (Character.isUpperCase(curr)) {
            return curr - 'A' + 1;
        }
        return curr - 'a' + 1;
    }
}


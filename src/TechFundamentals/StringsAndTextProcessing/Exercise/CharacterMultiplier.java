package TechFundamentals.StringsAndTextProcessing.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split(" ");
        String firstWord = words[0];
        String secondWord = words[1];
        int minLength = Math.min(firstWord.length(), secondWord.length());
        int sum = 0;
        for (int i = 0; i < minLength; i++) {
            int firstWordChar = (int) firstWord.charAt(i);
            int secondWordChar = (int) secondWord.charAt(i);
            int multiplier = 0;
            multiplier = firstWordChar * secondWordChar;
            sum += multiplier;
        }
        if (firstWord.length() > secondWord.length()) {
            for (int i = minLength; i < firstWord.length(); i++) {
                sum += (int) firstWord.charAt(i);
            }
        } else if (firstWord.length() < secondWord.length()) {
            for (int i = minLength; i < secondWord.length(); i++) {
                sum += (int) secondWord.charAt(i);
            }
        }
        System.out.println(sum);


    }
}

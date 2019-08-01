package TechFundamentals.StringsAndTextProcessing.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] bannedWords = reader.readLine().split(", ");
        String text = reader.readLine();
        for (String bannedWord : bannedWords) {
            String replaceWord = repeatString(bannedWord);
            text = text.replace(bannedWord, replaceWord);
        }
        System.out.println(text);

    }
    private static String repeatString(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            result.append("*");
        }
        return result.toString();
    }
}

package TechFundamentals.Methods.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VowelCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        int count = 0;
        countOfAppearances(word, count);
    }
    private static void countOfAppearances(String word, int count) {
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o'|| temp == 'u') {
                count++;
            }
        }
        System.out.println(count);
    }
}
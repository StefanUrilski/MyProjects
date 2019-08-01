package TechFundamentals.StringsAndTextProcessing.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Substring {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String wordForRemove = reader.readLine();
        String word = reader.readLine();

        while (word.contains(wordForRemove)) {
            word = word.replace(wordForRemove, "");
        }
        System.out.println(word);
    }
}

package TechFundamentals.ObjectsAndClasses.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> words = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        Random rnd = new Random();
        for (int i = 0; i < words.size(); i++) {
            int index = rnd.nextInt(words.size());
            String temp = words.get(i);
            words.set(i, words.get(index));
            words.set(index, temp);
        }
        for (String word : words) {
            System.out.println(word);
        }

    }
}

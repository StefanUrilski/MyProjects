package TechFundamentals.MapsLambdaAndStreamAPI.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WordFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split("\\s+");

        Arrays.stream(words).filter(s -> s.length() % 2 == 0)
                .forEach(System.out::println);

    }
}

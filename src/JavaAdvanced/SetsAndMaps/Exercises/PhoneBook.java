package SetsAndMaps.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Map<String, String> book = new HashMap<>();
        while (! "search".equals(input = reader.readLine())) {
            String[] tokens = input.split("-");
            book.put(tokens[0], tokens[1]);
        }
        while (! "stop".equals(input = reader.readLine())) {
            if (book.containsKey(input)) {
                System.out.println(String.format("%s -> %s", input, book.get(input)));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
        }

    }
}

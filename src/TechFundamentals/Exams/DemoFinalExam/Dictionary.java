package Exams.DemoFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dictionary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> diction = new TreeMap<>();
        String input = reader.readLine();
        String[] wordsAndDefinition = input.split(" \\| ");
        for (String aWordsAndDefinition : wordsAndDefinition) {
            String[] tokens = aWordsAndDefinition.split(": ");
            String word = tokens[0];
            String def = tokens[1];
            diction.putIfAbsent(word, new ArrayList<>());
            diction.get(word).add(def);
        }
        input = reader.readLine();
        String[] tokens = input.split(" \\| ");
        Map<String, List<String>> forPrinting = new LinkedHashMap<>();
        for (String token : tokens) {
            if (diction.containsKey(token)) {
                forPrinting.put(token, diction.get(token));
            }
        }
        forPrinting.forEach((key, value) -> value.sort((o1, o2) -> Integer.compare(o2.length(), o1.length())));
        forPrinting.forEach((key, value) -> {
            System.out.println(key);
            for (String aValue : value) {
                System.out.println("-" + aValue);
            }
        });
        input = reader.readLine();

        if (input.equals("ListNode")) {
            for (String key : diction.keySet()) {
                System.out.print(key + " ");
            }
            System.out.println();
        }
    }
}

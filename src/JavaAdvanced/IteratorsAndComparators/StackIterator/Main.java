package IteratorsAndComparators.StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stack stack = new Stack();

        String line = reader.readLine();

        while (!line.equals("END")) {
            String[] commands = line.split("\\s+");
            switch (commands[0]) {
                case "Push":
                    addingElements(stack, line);
                    break;
                case "Pop":
                    if (stack.isEmpty()) {
                        System.out.println("No elements");
                    } else {
                        stack.pop();
                    }
                    break;
            }

            line = reader.readLine();
        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);

    }

    private static void addingElements(Stack stack, String input) {
        String line = input.substring(input.indexOf(" ") + 1);
        String[] values = line.split(", ");

        for (String value : values) {
            value = value.trim();
            stack.push(Integer.valueOf(value));
        }


    }
}

package IteratorsAndComparators.ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] elements = reader.readLine().split("\\s+");

        ListIterator iterator = new ListIterator();

        for (int i = 1; i < elements.length; i++) {
            iterator.add(elements[i]);
        }

        commandParser(iterator);

    }

    private static void commandParser(ListIterator list) throws IOException {
        String line = reader.readLine();

        while (! line.equals("END")) {
            switch (line) {
                case "Move":
                    System.out.println(list.move());
                    break;
                case "HasNext":
                    System.out.println(list.iterator().hasNext());
                    break;
                case "Print":
                    if (list.size() == 0) {
                        System.out.println("Invalid JavaOOP.Polymorphism.Calculator.Operation!");
                    } else {
                        System.out.println(list.iterator().next());
                    }
                    break;
                case "PrintAll":
                    if (list.size() == 0) {
                        System.out.println("Invalid JavaOOP.Polymorphism.Calculator.Operation!");
                    } else {
                        list.forEach(e -> System.out.print(e + " "));
                        System.out.println();
                    }
                    break;
            }


            line = reader.readLine();
        }
    }
}

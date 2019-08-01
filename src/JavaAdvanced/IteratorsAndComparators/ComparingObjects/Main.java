package IteratorsAndComparators.ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        List<Person> people = new ArrayList<>();

        while (!line.equals("END")) {
            String[] parts = line.split("\\s+");

            Person person = new Person(parts[0], Integer.valueOf(parts[1]), parts[2]);

            people.add(person);
            line = reader.readLine();
        }

        line = reader.readLine();
        Person person = people.get(Integer.valueOf(line) - 1);

        int count = people.stream().filter(p -> p.compareTo(person) == 0).toArray().length;

        if (count == 1) {
            System.out.println("No matches");
        } else {
            int size = people.size();
            System.out.println(String.format("%d %d %d", count, size - count, size));
        }

    }
}

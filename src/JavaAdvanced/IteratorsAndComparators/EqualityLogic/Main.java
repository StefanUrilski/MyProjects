package IteratorsAndComparators.EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> peopleInTreeSet = new TreeSet<>();
        HashSet<Person> peopleInHashSet = new HashSet<>();

        int n = Integer.valueOf(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.valueOf(tokens[1]);

            Person person = new Person(name, age);

            peopleInTreeSet.add(person);
            peopleInHashSet.add(person);
        }

        System.out.println(peopleInTreeSet.size());
        System.out.println(peopleInHashSet.size());

    }
}

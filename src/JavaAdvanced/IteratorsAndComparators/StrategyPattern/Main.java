package IteratorsAndComparators.StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        TreeSet<Person> sortByName = new TreeSet<>(new ComparatorByName());
        TreeSet<Person> sortByAge = new TreeSet<>(new ComparatorByAge());

        while(n-- > 0) {
            String[] parts = reader.readLine().split("\\s+");

            Person person = new Person(parts[0], Integer.valueOf(parts[1]));

            sortByName.add(person);
            sortByAge.add(person);
        }

//        sortByName.stream().sorted(Person::compareTo).forEach(System.out::println);
//        sortByAge.stream().sorted(Person::compareToByAge).forEach(System.out::println);

        sortByName.forEach(System.out::println);
        sortByAge.forEach(System.out::println);

    }
}

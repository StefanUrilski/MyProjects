package DefiningClasses.Exercises.OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rotations = Integer.valueOf(reader.readLine());

        List<Person> peoples = new ArrayList<>();

        while (rotations-- > 0) {

            String[] tokens = reader.readLine().split("\\s+");

            Person p = new Person(tokens[0], Integer.valueOf(tokens[1]));

            peoples.add(p);
        }

        peoples.stream().filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));

    }
}

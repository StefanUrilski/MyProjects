package DefiningClasses.Exercises.Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        Map<String, Person> people = new HashMap<>();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");

            String personName = tokens[0];
            Person person;
            if (people.containsKey(personName)) {
                person = people.get(personName);
            } else {
                person = new Person(personName);
            }
            String add = tokens[1];
            String name = tokens[2];
            String property = tokens[3];

            switch (add) {
                case "company":
                    Company company = new Company(name, property, Double.valueOf(tokens[4]));
                    person.setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(name, property);
                    person.getPokemon().add(pokemon);
                    break;
                case "parents":
                    Parent parent = new Parent(name, property);
                    person.getParents().add(parent);
                    break;
                case "children":
                    Children children = new Children(name, property);
                    person.getChildren().add(children);
                    break;
                case "car":
                    Car car = new Car(name, property);
                    person.setCar(car);
                    break;
            }

            people.putIfAbsent(personName, person);

            line = reader.readLine();
        }

        String printName = reader.readLine();

        Map.Entry<String, Person> wantedPerson = people.entrySet().stream()
                .filter(p -> p.getKey().equals(printName))
                .findFirst()
                .get();
        printPerson(wantedPerson.getValue());
    }

    private static void printPerson(Person person) {

        System.out.println(person.getName());
        if (person.getCompany() == null) {
            System.out.println("Company:");
        } else {
            System.out.println(person.getCompany());
        }
        if (person.getCar() == null) {
            System.out.println("Car:");
        } else {
            System.out.println(person.getCar());
        }
        System.out.println("Pokemon:");
        person.getPokemon().forEach(System.out::println);
        System.out.println("Parents:");
        person.getParents().forEach(System.out::println);
        System.out.println("Children:");
        person.getChildren().forEach(System.out::println);
    }
}

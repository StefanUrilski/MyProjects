package TechFundamentals.ObjectsAndClasses.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<People> peoplesList = new ArrayList<>();
        String input = reader.readLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            int age = Integer.valueOf(tokens[2]);
            People people = new People(tokens[0], tokens[1], age);
            peoplesList.add(people);
            input = reader.readLine();
        }
        peoplesList.stream().sorted(Comparator.comparingInt(People::getAge)).forEach(System.out::println);
    }
}

class People {
    private String name;
    private String id;
    private int age;

    public People(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return getName() + " with ID: " + getId() + " is " + getAge() + " years old.";
    }
}

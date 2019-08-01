package JavaOOP.Polymorphism.WildFarm;

import JavaOOP.Polymorphism.WildFarm.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();

        String line = reader.readLine();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            double weight = Double.parseDouble(tokens[2]);
            String region = tokens[3];

            Animal animal = null;
            switch (type) {
                case "Cat":
                    animal = new Cat(type, name, weight, region, tokens[4]);
                    break;
                case "Tiger":
                    animal = new Tiger(type, name, weight, region);
                    break;
                case "Mouse":
                    animal = new Mouse(type, name, weight, region);
                    break;
                default:
                    animal = new Zebra(type, name, weight, region);
                    break;
            }

            tokens = reader.readLine().split("\\s+");

            Food food = null;
            if (tokens[0].equals("Meat")) {
                food = new Meat(Integer.parseInt(tokens[1]));
            } else {
                food = new Vaegetable(Integer.parseInt(tokens[1]));
            }

            animals.add(animal);
            foods.add(food);

            line = reader.readLine();
        }

        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).makeSound());
            try {
                animals.get(i).eatFood(foods.get(i));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}

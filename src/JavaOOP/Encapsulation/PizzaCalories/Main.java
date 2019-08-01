package JavaOOP.Encapsulation.PizzaCalories;

import JavaOOP.Encapsulation.PizzaCalories.pizzaParam.Pizza;
import JavaOOP.Encapsulation.PizzaCalories.pizzaParam.dough.Dough;
import JavaOOP.Encapsulation.PizzaCalories.pizzaParam.topping.Topping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaOrder = readData(reader.readLine());
        String[] doughOrder = readData(reader.readLine());

        Dough dough;
        Pizza pizza;

        try {
            pizza = new Pizza(pizzaOrder[0], Integer.parseInt(pizzaOrder[1]));
            dough = new Dough(doughOrder[0], doughOrder[1] ,Double.parseDouble(doughOrder[2]));
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String line = reader.readLine();
        while (! line.equals("END")) {
            try{
                String[] toppingOrder = readData(line);
                Topping topping = new Topping(toppingOrder[0], Double.parseDouble(toppingOrder[1]));
                pizza.addTopping(topping);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }

            line = reader.readLine();
        }

        System.out.println(String.format("%s - %.2f", pizzaOrder[0], pizza.getOverallCalories()));

    }

    private static String[] readData(String input) {
        return Arrays.stream(input.split("\\s+")).skip(1).toArray(String[]::new);
    }
}

package JavaOOP.Encapsulation.PizzaCalories.pizzaParam;

import JavaOOP.Encapsulation.PizzaCalories.pizzaParam.dough.Dough;
import JavaOOP.Encapsulation.PizzaCalories.pizzaParam.topping.Topping;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int toppings) {
        this.setName(name);
        this.setToppings(toppings);
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int capacity) {
        if (capacity < 0 || capacity > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.toppings = new ArrayList<>(capacity);
    }

    public void addTopping (Topping topping) {
        if (this.toppings.size() == 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.toppings.add(topping);
    }

    public double getOverallCalories () {
        double result = this.dough.calculateCalories();

        for (Topping topping : this.toppings) {
            result += topping.calculateCalories();
        }

        return result;
    }
}

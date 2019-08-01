package JavaOOP.Encapsulation.PizzaCalories.pizzaParam.topping;

public enum ToppingTypes {
    Meat(1.2),
	Veggies(0.8),
	Cheese(1.1),
	Sauce(0.9);

    double getCalories;

    ToppingTypes(double getCalories) {
        this.getCalories = getCalories;
    }

}

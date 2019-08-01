package JavaOOP.Encapsulation.PizzaCalories.pizzaParam.dough;

public enum FlourType {
    White(1.5),
    Wholegrain(1.0);

    double getCalories;

    FlourType(double getCalories) {
        this.getCalories = getCalories;
    }
}

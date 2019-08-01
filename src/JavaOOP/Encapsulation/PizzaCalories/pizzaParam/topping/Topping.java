package JavaOOP.Encapsulation.PizzaCalories.pizzaParam.topping;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private String getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
        if (! containsToppingType(toppingType)) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.getToppingType() + " weight should be in the range [1..50].");
        }

        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * this.weight) * ToppingTypes.valueOf(this.toppingType).getCalories;
    }

    private boolean containsToppingType(String toppingType) {
        for (ToppingTypes type : ToppingTypes.values()) {
            if (toppingType.equals(type.name())) {
                return true;
            }
        }

        return false;
    }
}

package JavaOOP.Encapsulation.ShoppingSpree.data;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        if (!Validator.ValidName(name)) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private void setCost(double cost) {
        if (!Validator.ValidMoney(cost)) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public double getCost(){
        return this.cost;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
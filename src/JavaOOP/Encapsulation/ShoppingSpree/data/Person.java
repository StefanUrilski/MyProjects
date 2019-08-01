package JavaOOP.Encapsulation.ShoppingSpree.data;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private  void setName(String name) {
        if (! Validator.ValidName(name)) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private void setMoney(double money) {
        if (! Validator.ValidMoney(money)) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public double getMoney() {
        return this.money;
    }

    public void buyProduct(Product product) {
        if (this.money - product.getCost() < 0) {
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        }

        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" - ");
        if (this.products.size() == 0) {
            sb.append("Nothing bought");
        } else {
            String result = String.join(", ", this.products.toString());
            sb.append(result.replaceAll("[\\[\\]]", ""));
        }

        return sb.toString();
    }
}

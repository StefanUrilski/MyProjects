package JavaOOP.Polymorphism.WildFarm.models;

public abstract class Food {
    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }
}

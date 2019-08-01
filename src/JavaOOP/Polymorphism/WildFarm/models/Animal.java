package JavaOOP.Polymorphism.WildFarm.models;

public abstract class Animal {
    private String type;
    private String name;
    private double weight;
    private int foodEaten;

    public Animal(String type, String name, double weight) {
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.foodEaten = 0;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getFoodEaten() {
        return this.foodEaten;
    }

    public void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract String makeSound();

    public abstract void eatFood(Food food);

}

package JavaOOP.Polymorphism.WildFarm.models;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private static final DecimalFormat DF = new DecimalFormat("######.##");

    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public void eatFood(Food food) {
        super.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getType(),
                super.getName(),
                this.breed,
                Cat.DF.format(super.getWeight()),
                super.getLivingRegion(),
                super.getFoodEaten()
        );
    }
}

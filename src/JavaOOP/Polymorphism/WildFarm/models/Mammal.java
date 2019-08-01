package JavaOOP.Polymorphism.WildFarm.models;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal  {
    private static final DecimalFormat DF = new DecimalFormat("######.##");

    private String livingRegion;

    protected String getLivingRegion(){
        return this.livingRegion;
    }

    public Mammal(String type, String name, double weight, String region) {
        super(type, name, weight);
        this.livingRegion = region;
    }

    @Override
    public void eatFood(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            super.setFoodEaten(food.getQuantity());
            return;
        }
        String animalType = this.getClass().getSimpleName().equals("Mouse") ? "Mice" : "Zebras";

        throw new IllegalArgumentException(animalType + " are not eating that type of food!");
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                super.getType(),
                super.getName(),
                Mammal.DF.format(super.getWeight()),
                this.livingRegion,
                super.getFoodEaten()
        );
    }
}

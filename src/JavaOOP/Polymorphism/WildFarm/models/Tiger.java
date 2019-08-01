package JavaOOP.Polymorphism.WildFarm.models;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public void eatFood(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            super.setFoodEaten(food.getQuantity());
            return;
        }
        throw new IllegalArgumentException("Tigers are not eating that type of food!");
    }
}

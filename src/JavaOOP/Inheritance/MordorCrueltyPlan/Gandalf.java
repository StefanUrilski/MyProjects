package JavaOOP.Inheritance.MordorCrueltyPlan;

public class Gandalf {
    private int foodPoints;

    public Gandalf() {
        this.foodPoints = 0;
    }

    public int getFoodPoints() {
        return this.foodPoints;
    }

    public void eatFood(String food) {
        try {
            int temp = Food.valueOf(food.toLowerCase()).getHappiness();
            this.foodPoints += temp;
        } catch (Exception e) {
            this.foodPoints--;
        }
    }

    public String getMood() {
        String mood;
        if (this.foodPoints < -5) {
            mood = "Angry";
        } else if (this.foodPoints < 0) {
            mood = "Sad";
        } else if (this.foodPoints < 15) {
            mood = "Happy";
        } else {
            mood = "JavaScript";
        }

        return mood;
    }
}

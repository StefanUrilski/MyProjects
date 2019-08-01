package JavaOOP.Inheritance.MordorCrueltyPlan;

public enum Food {
    cram(2),
    lembas(3),
    apple(1),
    melon(1),
    honeycake(5),
    mushrooms(-10);

    private int happiness;

    Food(int happiness){
        this.happiness = happiness;
    }

    public int getHappiness() {
        return this.happiness;
    }
}

package DefiningClasses.Exercises.Google;

public class Car {
    private String model;
    private String speed;

    public Car(String model, String speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("Car:%n%s %s", model, speed);
    }
}

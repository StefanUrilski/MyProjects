package DefiningClasses.Exercises.CarSalesmen;

public class Car {
    private static final String DEFAULT_VALUE = "n/a";

    private String model;
    private String weight;
    private String color;
    private Engine engine;


    public Car(String model, String weight, String color, Engine engine) {
        this.model = model;
        this.weight = weight;
        this.color = color;
        this.engine = engine;
    }

    public Car(String model, Engine engine) {
        this(model, DEFAULT_VALUE, DEFAULT_VALUE, engine);
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private Engine getEngine() {
        return this.engine;
    }

    @Override
    public String toString() {
        return String.format(this.model + ":%n" + getEngine() + "Weight: %s%nColor: %s", this.weight, this.color);
    }
}

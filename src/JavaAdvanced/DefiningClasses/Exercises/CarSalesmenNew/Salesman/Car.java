package DefiningClasses.Exercises.CarSalesmenNew.Salesman;

public class Car {
    private static final String DEFAULT_VALUE = "n/a";
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = Car.DEFAULT_VALUE;
        this.color = Car.DEFAULT_VALUE;
    }

//    public Car(String model, engine engine, String weight, String color) {
//        this(model, engine);
//        this.weight = weight;
//        this.color = color;
//    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.model + ":" + System.lineSeparator() + this.engine + System.lineSeparator()
                + "Weight: " + this.weight + System.lineSeparator() + "Color: " + this.color;
    }
}

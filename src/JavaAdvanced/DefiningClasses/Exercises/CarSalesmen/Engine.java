package DefiningClasses.Exercises.CarSalesmen;

public class Engine {
    private static final String DEFAULT_VALUE = "n/a";

    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String model, int power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this(model, power, DEFAULT_VALUE, DEFAULT_VALUE);
    }

    public String getModel() {
        return this.model;
    }
    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%n",
                this.model, this.power, this.displacement, this.efficiency);
    }
}

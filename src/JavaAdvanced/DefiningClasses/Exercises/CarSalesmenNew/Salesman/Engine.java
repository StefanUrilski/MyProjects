package DefiningClasses.Exercises.CarSalesmenNew.Salesman;

public class Engine {
    private static final String DEFAULT_VALUE = "n/a";
    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
        this.displacement = Engine.DEFAULT_VALUE;
        this.efficiency = Engine.DEFAULT_VALUE;
    }

//    public engine(String model, String power, String displacement, String efficiency) {
//        this(model, power);
//        this.displacement = displacement;
//        this.efficiency = efficiency;
//    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return this.model + ":" + System.lineSeparator() + "Power: " + this.power + System.lineSeparator()
                + "Displacement: " + this.displacement + System.lineSeparator() + "Efficiency: " + this.efficiency;
    }
}

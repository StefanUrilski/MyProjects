package DefiningClasses.Exercises.SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distance;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distance = 0;
    }

    public boolean drive(int amountOfKm) {
        double fuelNeeded = amountOfKm * this.fuelCostFor1km;
        if (fuelNeeded <= this.fuelAmount) {
            this.fuelAmount -= fuelNeeded;
            this.distance += amountOfKm;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
    }
}

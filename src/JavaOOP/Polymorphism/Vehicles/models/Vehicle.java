package JavaOOP.Polymorphism.Vehicles.models;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private DecimalFormat decimalFormat = new DecimalFormat("#####.##");
    private double fuelQuantity;
    private double fuelConsumption;
    private int tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance) {
        String result;
        double litersNeeded = distance * this.fuelConsumption;

        if (this.fuelQuantity >= litersNeeded) {
            this.fuelQuantity -= litersNeeded;
            result = String.format("%s travelled %s km",
                    this.getClass().getSimpleName(), this.decimalFormat.format(distance));
        } else {
            result = String.format("%s needs refueling", this.getClass().getSimpleName());
        }

        return result;
    }

    public void refuel(double liters) {
        this.fuelQuantity = liters;
    }

    protected boolean hasTankCapacity(double liters) {
        return this.fuelQuantity + liters <= this.tankCapacity;
    }
}

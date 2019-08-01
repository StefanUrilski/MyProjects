package JavaOOP.Polymorphism.Vehicles.models;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    private DecimalFormat decimalFormat = new DecimalFormat("#####.##");
    private static final double AC_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }


    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + Bus.AC_CONSUMPTION);
    }

    public String driveEmpty(double distance) {
        return super.drive(distance * Bus.AC_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        if (! this.hasTankCapacity(liters)) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        super.refuel(this.getFuelQuantity() + liters);
    }
}

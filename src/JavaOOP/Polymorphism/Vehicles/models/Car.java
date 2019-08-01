package JavaOOP.Polymorphism.Vehicles.models;

public class Car extends Vehicle {
    private static final double AC_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + Car.AC_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        if (! this.hasTankCapacity(liters)) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.refuel(this.getFuelQuantity() + liters);
    }
}

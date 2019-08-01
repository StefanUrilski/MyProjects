package JavaOOP.Polymorphism.Vehicles.models;

public class Truck extends Vehicle {
    private static final double AC_CONSUMPTION = 1.6;
    private static final double HOLE_LEAK = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + Truck.AC_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        if (! this.hasTankCapacity(liters)) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.refuel(this.getFuelQuantity() + (liters * Truck.HOLE_LEAK));
    }
}

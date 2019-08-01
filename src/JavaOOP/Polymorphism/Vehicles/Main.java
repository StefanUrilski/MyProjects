package JavaOOP.Polymorphism.Vehicles;

import JavaOOP.Polymorphism.Vehicles.models.Bus;
import JavaOOP.Polymorphism.Vehicles.models.Car;
import JavaOOP.Polymorphism.Vehicles.models.Truck;
import JavaOOP.Polymorphism.Vehicles.models.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Integer.parseInt(tokens[3]));

        tokens = reader.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Integer.parseInt(tokens[3]));

        tokens = reader.readLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(tokens[1]),
                Double.parseDouble(tokens[2]),
                Integer.parseInt(tokens[3]));

        int n = Integer.valueOf(reader.readLine());

        while (n-- > 0) {
            tokens = reader.readLine().split("\\s+");
            double value = Double.parseDouble(tokens[2]);
            if (value <= 0) {
                System.out.println("Fuel must be a positive number");
                continue;
            }
            try {
                if (tokens[0].equals("Drive")) {
                    if (tokens[1].equals("Car")) {
                        System.out.println(car.drive(value));
                    } else if (tokens[1].equals("Truck")) {
                        System.out.println(truck.drive(value));
                    } else {
                        System.out.println(bus.drive(value));
                    }
                } else if (tokens[0].equals("Refuel")) {
                    if (tokens[1].equals("Car")) {
                        car.refuel(value);
                    } else if (tokens[1].equals("Truck")) {
                        truck.refuel(value);
                    } else {
                        bus.refuel(value);
                    }
                } else {
                    if (tokens[1].equals("Bus")) {
                        System.out.println(bus.driveEmpty(value));
                    }
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(String.format("Car: %.2f", car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f", truck.getFuelQuantity()));
        System.out.println(String.format("Bus: %.2f", bus.getFuelQuantity()));
    }
}

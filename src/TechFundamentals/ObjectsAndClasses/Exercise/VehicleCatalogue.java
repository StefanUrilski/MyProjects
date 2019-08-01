package TechFundamentals.ObjectsAndClasses.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class VehicleCatalogue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Vehicle> vehiclesList = new ArrayList<>();
        double truckSum = 0;
        int truckCount = 0;
        double carSum = 0;
        int carCount = 0;
        String input = reader.readLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            int horsepower = Integer.valueOf(tokens[3]);
            Vehicle vehicle = new Vehicle(tokens[0], tokens[1], tokens[2], horsepower);
            if (vehicle.getType().equals("car")) {
                carSum += vehicle.getHorsepower();
                carCount++;
            } else if (vehicle.getType().equals("truck")){
                truckSum += vehicle.getHorsepower();
                truckCount++;
            }
            vehiclesList.add(vehicle);
            input = reader.readLine();
        }
        while (true) {
            String modelToPrint = reader.readLine();
            if (modelToPrint.equals("Close the Catalogue")) {
                break;
            }
            vehiclesList.stream().filter(e -> e.getModel().equals(modelToPrint))
                    .forEach(e -> {
                        String type = "Truck";
                        if (e.getType().equals("car")) {
                            type = "Car";
                        }
                        System.out.printf("Type: " + type + "%nModel: " + e.getModel()
                                + "%nColor: " + e.getColor() + "%nHorsepower: " + e.getHorsepower() + "%n");
                    });
        }
        double carAverage = carSum / carCount;
        double truckAverage = truckSum / truckCount;
        if (carCount == 0) {
            carAverage = 0;
        }
        if (truckCount == 0) {
            truckAverage = 0;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", carAverage);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", truckAverage);
    }
}
class Vehicle {
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public Vehicle(String type, String model, String color, int horsepower) {
        this.setType(type);
        this.setModel(model);
        this.setColor(color);
        this.setHorsepower(horsepower);
    }
    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    private void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

}

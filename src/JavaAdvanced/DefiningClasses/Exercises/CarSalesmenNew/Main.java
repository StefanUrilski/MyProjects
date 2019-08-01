package DefiningClasses.Exercises.CarSalesmenNew;

import DefiningClasses.Exercises.CarSalesmenNew.Salesman.Car;
import DefiningClasses.Exercises.CarSalesmenNew.Salesman.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int engineCount = Integer.valueOf(reader.readLine());

        Map<String, Engine> engines = new HashMap<>();

        while (engineCount-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            Engine engine = new Engine(tokens[0], tokens[1]);

            if (tokens.length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    engine.setDisplacement(tokens[2]);
                } else {
                    engine.setEfficiency(tokens[2]);
                }
            } else if (tokens.length == 4){
                engine.setDisplacement(tokens[2]);
                engine.setEfficiency(tokens[3]);
            }

            engines.put(tokens[0], engine);
        }

        int carCount = Integer.valueOf(reader.readLine());

        List<Car> cars = new ArrayList<>();

        while (carCount-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            Engine engine = engines.get(tokens[1]);
            Car car = new Car(tokens[0], engine);

            if (tokens.length == 3) {
                if (Character.isLetter(tokens[2].charAt(0))) {
                    car.setColor(tokens[2]);
                } else {
                    car.setWeight(tokens[2]);
                }
            } else if (tokens.length == 4){
                car.setWeight(tokens[2]);
                car.setColor(tokens[3]);
            }

            cars.add(car);

        }

        cars.forEach(System.out::println);

    }
}

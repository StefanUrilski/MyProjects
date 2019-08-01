package DefiningClasses.Exercises.CarSalesmen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfEngines = Integer.valueOf(reader.readLine());

        Map<String, Engine> engines = new LinkedHashMap<>();

        while (numberOfEngines-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            Engine engine = new Engine(tokens[0], Integer.valueOf(tokens[1]));

            if (tokens.length == 3) {
                if (Character.isLetter(tokens[2].charAt(0))) {
                    engine.setEfficiency(tokens[2]);
                } else {
                    engine.setDisplacement(tokens[2]);
                }
            } else if (tokens.length == 4) {
                engine.setDisplacement(tokens[2]);
                engine.setEfficiency(tokens[3]);
            }
            engines.put(tokens[0], engine);
        }

        int numberOfCars = Integer.valueOf(reader.readLine());


        List<Car> cars = new ArrayList<>();
        while (numberOfCars-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            Car car = new Car(tokens[0], engines.get(tokens[1]));

            if (tokens.length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    car.setWeight(tokens[2]);
                } else {
                    car.setColor(tokens[2]);
                }
            } else if (tokens.length == 4) {
                car.setWeight(tokens[2]);
                car.setColor(tokens[3]);
            }
            cars.add(car);
        }


        cars.forEach(System.out::println);

    }
}

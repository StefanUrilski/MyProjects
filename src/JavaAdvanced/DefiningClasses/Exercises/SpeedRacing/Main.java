package DefiningClasses.Exercises.SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            Car car = new Car(tokens[0],Double.valueOf(tokens[1]), Double.parseDouble(tokens[2]));

            cars.put(tokens[0], car);
        }

        String line = reader.readLine();

        while (!line.equals("End")) {

            String[] tokens = line.split("\\s+");
            String model = tokens[1];
            int distanceTravel = Integer.parseInt(tokens[2]);

            if (!cars.get(model).drive(distanceTravel)) {
                System.out.println("Insufficient fuel for the drive");
            }

            line = reader.readLine();
        }
        cars.forEach((key, value) -> System.out.println(value));
    }
}

package DefiningClasses.Exercises.RowData;

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

            String model = tokens[0];
            int horsePower = Integer.valueOf(tokens[2]);
            String cargo = tokens[4];
            double firstTire = Double.valueOf(tokens[5]);
            double secondTire = Double.valueOf(tokens[7]);
            double thirdTire = Double.valueOf(tokens[9]);
            double fourthTire = Double.valueOf(tokens[11]);

            Car car = new Car(model, horsePower, cargo, firstTire, secondTire, thirdTire, fourthTire);

            cars.put(model, car);
        }

        String type = reader.readLine();
        if (type.equals("fragile")) {
            cars.entrySet().stream().filter(cargo -> cargo.getValue().getCargo().equals(type))
                    .filter(tire -> tire.getValue().checkPressure())
                    .forEach(car -> System.out.println(car.getValue()));
        } else {
            cars.entrySet().stream().filter(cargo -> cargo.getValue().getCargo().equals(type))
                    .filter(tire -> tire.getValue().checkPower())
                    .forEach(car -> System.out.println(car.getValue()));
        }
    }
}

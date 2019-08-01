package forExam.C_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BC_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.valueOf(reader.readLine());
        int foodKG = Integer.valueOf(reader.readLine());
        double dogFoodKG = Double.valueOf(reader.readLine());
        double catFoodKG = Double.valueOf(reader.readLine());
        double turtleFoodKG = Double.valueOf(reader.readLine()) / 1000;

        double dogsFoodNeeded = days * dogFoodKG;
        double catsFoodNeeded = catFoodKG * days;
        double turtlesFoodNeeded = turtleFoodKG * days;
        double overall = dogsFoodNeeded + catsFoodNeeded +turtlesFoodNeeded;
        double difference = foodKG - overall;

        if (difference >= 0) {
            System.out.printf("%.0f kilos of food left.", Math.floor(difference));
        } else {
            difference = Math.abs(difference);
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(difference));
        }

    }
}

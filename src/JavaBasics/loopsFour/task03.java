package forExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double budget = Double.valueOf(reader.readLine());
        String season = reader.readLine();
        String location = "";
        String place = "";

        if (budget < 101) {
            location = "Bulgaria";
            if (season.equals("summer")) {
                budget *= 0.3;
            } else {
                budget *= 0.7;
            }
        } else if (budget < 1001) {
            location = "Balkans";
            if (season.equals("summer")) {
                budget *= 0.4;
            } else {
                budget *= 0.8;
            }
        } else {
            location = "Europe";
            budget *= 0.9;
        }

        if (location.equals("Europe")) {
            place = "Hotel";
        } else {
            if (season.equals("summer")) {
                place = "Camp";
            } else {
                place = "Hotel";
            }
        }
        System.out.printf("Somewhere in %s\n", location);
        System.out.printf("%s - %.2f", place, budget);
    }
}

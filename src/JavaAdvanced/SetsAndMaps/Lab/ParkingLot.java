package OtherCourses.SetsAndMaps.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        Set<String> parkingLot = new HashSet<>();
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(", ");
            if ("IN".equals(tokens[0])) {
                parkingLot.add(tokens[1]);
            } else if ("OUT".equals(tokens[0])) {
                parkingLot.remove(tokens[1]);
            }

        }
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String cars : parkingLot) {
                System.out.println(cars);
            }
        }
    }
}

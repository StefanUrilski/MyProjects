package MapsLambdaAndStreamAPI.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SoftUniParking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfEntries = Integer.valueOf(reader.readLine());
        Map<String, String> parkingLot = new LinkedHashMap<>();
        for (int i = 0; i < numberOfEntries; i++) {
            String[] input = reader.readLine().split("\\s+");
            String username = input[1];
            if (input[0].equals("register")) {
                String licensePlateNumber = input[2];
                if (!parkingLot.containsKey(username)) {
                    parkingLot.put(username, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                } else {
                    System.out.println("ERROR: already registered with plate number "
                            + parkingLot.get(username));
                }
            } else if (input[0].equals("unregister")) {
                if (parkingLot.containsKey(username)) {
                    parkingLot.remove(username);
                    System.out.println(username + " unregistered successfully");
                } else {
                    System.out.printf("ERROR: user %s not found%n", username);
                }
            }
        }
        for (Map.Entry<String, String> entry : parkingLot.entrySet()) {
            System.out.println(String.format("%s => %s", entry.getKey(), entry.getValue()));
        }
    }
}

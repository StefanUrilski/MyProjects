package ZForExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class IronGirder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> destination = new LinkedHashMap<>();
        Map<String, Integer> passengers = new LinkedHashMap<>();

        String input;
        while (! "Slide rule".equals(input = reader.readLine())) {
            String[] tokens = input.split("->");
            String[] info = tokens[0].split(":");
            String town = info[0];
            int passengersCount = Integer.valueOf(tokens[1]);
            if (info[1].equals("ambush")) {
                if (destination.containsKey(town)) {
                    destination.put(town, 0);
                }
                if (passengers.containsKey(town)) {
                    passengers.put(town, passengers.get(town) - passengersCount);
                }
                continue;
            }
            int time = Integer.valueOf(info[1]);
            if (! destination.containsKey(town)) {
                destination.put(town, Integer.MAX_VALUE);
            }
            int currTime = destination.get(town);
            if (time < currTime || currTime == 0) {
                destination.put(town, time);
            }
            if (! passengers.containsKey(town)) {
                passengers.put(town, 0);
            }
            passengers.put(town, passengers.get(town) + passengersCount);
        }

        destination.entrySet().stream().filter(t -> t.getValue() > 0).sorted((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return Integer.compare(e1.getValue(),e2.getValue());
        }).forEach(town -> {
            int currPassengers = passengers.get(town.getKey());
            if (currPassengers != 0) {
                System.out.printf("%s -> Time: %d -> Passengers: %d%n",town.getKey(), town.getValue(), currPassengers);
            }
        });
    }
}

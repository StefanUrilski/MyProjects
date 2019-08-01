package MapsLambdaAndStreamAPI.Exercise;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrdersDifferentWithTwoMaps {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<Integer, Double>> orders = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!input.equals("buy")) {
            String[] inputOrder = input.split("\\s+");
            String nameOfOrder = inputOrder[0];
            double price = Double.valueOf(inputOrder[1]);
            int quantity = Integer.valueOf(inputOrder[2]);

            if (!orders.containsKey(nameOfOrder)) {
                orders.put(nameOfOrder, new LinkedHashMap<>());
            }
            orders.get(nameOfOrder).get(quantity + quantity);
            orders.get(nameOfOrder).remove(quantity);
            orders.get(nameOfOrder).put(quantity, price);
// not doing what it has to....
            input = reader.readLine();
        }
        for (
                Map.Entry<String, Map<Integer, Double>> entry : orders.entrySet()) {
            System.out.print(entry.getKey());
            entry.getValue().forEach((key, value) -> System.out.printf(" %.2f%n", key * value));

        }
    }
}

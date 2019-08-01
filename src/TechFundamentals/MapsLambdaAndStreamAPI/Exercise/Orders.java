package TechFundamentals.MapsLambdaAndStreamAPI.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Orders {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Double>> orders = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!input.equals("buy")) {
            String[] inputOrder = input.split("\\s+");
            String nameOfOrder = inputOrder[0];
            double price = Double.valueOf(inputOrder[1]);
            double quantity = Double.valueOf(inputOrder[2]);
            if (!orders.containsKey(nameOfOrder)){
                orders.put(nameOfOrder, new ArrayList<>());
            }
            if (orders.get(nameOfOrder).size() == 0) {
                orders.get(nameOfOrder).add(quantity);
                orders.get(nameOfOrder).add(price);
            } else {
                double quantityCount = orders.get(nameOfOrder).get(0);
                orders.get(nameOfOrder).set(0, quantityCount + quantity);
                orders.get(nameOfOrder).set(1, price);
            }
            input = reader.readLine();
        }
        for (Map.Entry<String, List<Double>> entry : orders.entrySet()) {
            double result = entry.getValue().get(0) * entry.getValue().get(1);
            System.out.printf("%s -> %.2f%n", entry.getKey(), result);
        }

    }
}

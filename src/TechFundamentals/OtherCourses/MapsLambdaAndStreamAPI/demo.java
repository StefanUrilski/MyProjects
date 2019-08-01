package OtherCourses.MapsLambdaAndStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class demo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        Map<String, Double> products = new LinkedHashMap<>();
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();

        while (!line.equals("buy")){

            String[] inputs = line.split(" ");
            String cmd = inputs[0];
            double price = Double.parseDouble(inputs[1]);
            int quantity = Integer.parseInt(inputs[2]);

            if (!products.containsKey(cmd)){
                products.put(cmd, price);
                productsQuantity.put(cmd,quantity);
            } else {
                products.put(cmd,price);
                productsQuantity.put(cmd, productsQuantity.get(cmd) + quantity);
            }


            line = reader.readLine();
        }

        for (String key : products.keySet()) {
            double sum = 0;
            for (String secondKey : productsQuantity.keySet()) {
                if (key.equals(secondKey)) {
                    double valueOne = products.get(key);
                    double valueTwo = productsQuantity.get(key);
                    sum += valueOne * valueTwo;
                    break;
                }
            }
            System.out.printf("%s -> %.2f%n", key, sum);
        }

    }
}

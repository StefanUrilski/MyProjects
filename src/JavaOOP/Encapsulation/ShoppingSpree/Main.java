package JavaOOP.Encapsulation.ShoppingSpree;

import JavaOOP.Encapsulation.ShoppingSpree.data.Person;
import JavaOOP.Encapsulation.ShoppingSpree.data.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] buyers = reader.readLine().split(";");
        String[] productsWithPrices = reader.readLine().split(";");

        HashMap<String, Person> people = new HashMap<>();
        HashMap<String, Product> products = new HashMap<>();

        try {
            for (String buyer : buyers) {
                String[] tokens = buyer.split("=");
                Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
                people.put(tokens[0], person);
            }

            for (String productsWithPrice : productsWithPrices) {
                String[] tokens = productsWithPrice.split("=");
                Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
                products.put(tokens[0], product);
            }

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String line = reader.readLine();

        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");

            Person currPerson = people.get(tokens[0]);
            Product currProduct = products.get(tokens[1]);

            try {
                currPerson.buyProduct(currProduct);
                System.out.println(tokens[0] + " bought " + tokens[1]);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            line = reader.readLine();
        }

        people.values().forEach(System.out::println);

    }
}

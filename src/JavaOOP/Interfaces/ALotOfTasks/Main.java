package JavaOOP.Interfaces.ALotOfTasks;

import JavaOOP.Interfaces.ALotOfTasks.contracts.Buyer;
import JavaOOP.Interfaces.ALotOfTasks.data.Citizen;
import JavaOOP.Interfaces.ALotOfTasks.data.Rebel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        Map<String, Buyer> customers = new HashMap<>();

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            if (tokens.length == 3) {
                Rebel rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                customers.put(tokens[0], rebel);
            } else {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                customers.put(tokens[0], citizen);
            }
        }

        String nameLine = reader.readLine();

        while (!nameLine.equals("End")) {
            if (customers.containsKey(nameLine)) {
                customers.get(nameLine).buyFood();
            }

            nameLine = reader.readLine();
        }

        System.out.println(customers.values().stream().mapToInt(Buyer::getFood).sum());

    }
}

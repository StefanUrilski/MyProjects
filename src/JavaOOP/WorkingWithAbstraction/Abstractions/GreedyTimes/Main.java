package JavaOOP.WorkingWithAbstraction.Abstractions.GreedyTimes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long capacity = Long.valueOf(reader.readLine());

        Bag bag = new Bag(capacity);

        String[] treasure = reader.readLine().split("\\s+");

        for (int i = 0; i < treasure.length; i += 2) {
            String item = treasure[i];
            long amount = Long.parseLong(treasure[i + 1]);

            if (item.length() == 3) {
                bag.addCash(item, amount);
            } else if (item.toLowerCase().endsWith("gem")) {
                bag.addGems(item, amount);
            } else if(item.equalsIgnoreCase("gold")) {
                bag.addGold(item, amount);
            }
        }

        System.out.println(bag);
    }
}

package TechFundamentals.Exams.DemoMidExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BakingRush {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputEvent = reader.readLine().split("\\|");
        int energy = 100;
        int coins = 100;
        for (String anInputEvent : inputEvent) {
            String[] currIndex = anInputEvent.split("-");
            int number = Integer.valueOf(currIndex[1]);
            switch (currIndex[0]) {
                case "rest":
                    if (energy == 100 && energy + number > 100) {
                        System.out.println("You gained 0 energy.");
                        System.out.println(String.format("Current energy: %d.", energy));
//                    } else if (energy + number > 100) {
//                        int overEnergy = energy + number - 100;
//                        System.out.println("You gained " + overEnergy + " energy.");
//                        System.out.println(String.format("Current energy: %d.", energy));
                    } else {
                        energy += number;
                        System.out.println("You gained " + number + " energy.");
                        System.out.println(String.format("Current energy: %d.", energy));
                    }
                    break;
                case "order":
                    if (energy - 30 >= 0) {
                        energy -= 30;
                        coins += number;
                        System.out.println("You earned " + number + " coins.");
                    } else {
                        energy += 50;
                        System.out.println("You had to rest!");
                    }
                    break;
                    default:
                        if (coins - number > 0) {
                            coins -=number;
                            System.out.println(String.format("You bought %s.", currIndex[0]));
                        } else {
                            System.out.println(String.format("Closed! Cannot afford %s.", currIndex[0]));
                            return;
                        }
                        break;
            }
        }
        System.out.println("Day completed!");
        System.out.println("Coins: " + coins);
        System.out.println("Energy: " + energy);

    }
}

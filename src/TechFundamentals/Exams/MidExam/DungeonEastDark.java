package TechFundamentals.Exams.MidExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DungeonEastDark {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int health = 100;
        int coins = 0;
        int countOfRooms = 1;
        String[] rooms = reader.readLine().split("\\|");

        for (String room : rooms) {
            String[] currRoom = room.split("\\s+");
            int number = Integer.parseInt(currRoom[1]);
            switch (currRoom[0]) {
                case "potion":
                    if (health == 100) {
                        System.out.println("You healed for 0 hp.\nCurrent health: 100 hp.\n");
                    } else if (health + number > 100) {
                        int healed = 100 - health;
                        health += healed;
                        System.out.println("You healed for " + healed + " hp.");
                        System.out.println("Current health: 100 hp.");
                    } else {
                        health += number;
                        System.out.println("You healed for " + number + " hp.");
                        System.out.println("Current health: " + health + " hp.");
                    }
                    break;
                case "chest":
                    coins += number;
                    System.out.println("You found " + number + " coins.");
                    break;
                default:
                    String monster = currRoom[0];
                    health -= number;
                    if (health <= 0) { // warning !!!
                        System.out.println("You died! Killed by " + monster + ".");
                        System.out.println("Best room: " + countOfRooms);
                        break;
                    } else {
                        System.out.println("You slayed " + monster + ".");
                    }
                    break;
            }
            countOfRooms++;
            if (health <= 0) {
                return;
            }
        }
        System.out.println("You've made it!");
        System.out.println("Coins: " + coins);
        System.out.println("Health: " + health);

    }
}

package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        Deque<Integer> diedPlants = new ArrayDeque<>(n);
        int[] plants = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int days = 0;

        while (true) {
            boolean someoneIsDead = false;
            for (int i = plants.length - 1; i > 0; i--) {
                if (plants[i - 1] < plants[i]) {
                    diedPlants.push(plants[i]);
                    someoneIsDead = true;
                }
            }

            if (!someoneIsDead) {
                System.out.println(days);
                return;
            }

            days++;

            int[] temp = new int[plants.length - diedPlants.size()];
            int index = 0;

            for (int plant : plants) {
                if (!diedPlants.isEmpty() && plant == diedPlants.peek()) {
                    diedPlants.pop();
                } else {
                    temp[index] = plant;
                    index++;
                }
            }
            plants = temp;

        }
    }
}

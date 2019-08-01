package Exam.ExamPreparation.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SecondNature {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> flowers = new ArrayDeque<>();
        ArrayDeque<Integer> water = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(flowers::offer);

        Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(water::push);

        List<Integer> secondNature = new LinkedList<>();

        while (!flowers.isEmpty() && !water.isEmpty()) {
            int currFlower = flowers.poll();
            int currWater = water.pop();

            if (currFlower == currWater) {
                secondNature.add(currFlower);
            } else if (currFlower < currWater) {
                int remainder = currWater - currFlower;
                if (!water.isEmpty()) {
                    remainder += water.pop();
                }
                water.push(remainder);
            } else {
                currFlower -= currWater;
                flowers.push(currFlower);
            }
        }

        if (flowers.isEmpty()) {
            for (Integer i : water) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (Integer i : flowers) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        if (secondNature.isEmpty()) {
            System.out.println("None");
        } else {
            for (Integer flower : secondNature) {
                System.out.print(flower + " ");
            }
        }
    }
}

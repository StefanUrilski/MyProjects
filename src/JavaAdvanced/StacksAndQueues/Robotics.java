package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokensOfRobots = reader.readLine().split(";");
        String[] robots = new String[tokensOfRobots.length];
        int[] workingTime = new int[tokensOfRobots.length];
        int[] processTime = new int[tokensOfRobots.length];
        for (int i = 0; i < tokensOfRobots.length; i++) {
            String[] tokens = tokensOfRobots[i].split("-");
            robots[i] = tokens[0];
            workingTime[i] = Integer.parseInt(tokens[1]);
        }
        String[] timeTokens = reader.readLine().split(":");
        long h = Integer.parseInt(timeTokens[0]) * 60 * 60;
        long m = Integer.parseInt(timeTokens[1]) * 60;
        long s = Integer.parseInt(timeTokens[2]);
        long seconds = h + m + s;
        ArrayDeque<String> tasks = new ArrayDeque<>();
        String input = "";
        while (!"End".equals(input = reader.readLine())) {
            tasks.offer(input);
        }
        while (!tasks.isEmpty()) {
            seconds++;

            String currProduct = tasks.poll();
            boolean isAssigned = false;

            for (int i = 0; i < robots.length; i++) {
                if (processTime[i] == 0 && !isAssigned) {
                    processTime[i] = workingTime[i];
                    System.out.printf("%s - %s [%s]%n", robots[i], currProduct, convertingTime(seconds));
                    isAssigned = true;
                }
                if (processTime[i] > 0) {
                    processTime[i]--;
                }
            }
            if (!isAssigned) {
                tasks.offer(currProduct);
            }
        }
    }

    private static String convertingTime(long sec) {
        long s = sec % 60;
        long m = (sec / 60)% 60;
        long h = (sec / (60 * 60)) % 24;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}

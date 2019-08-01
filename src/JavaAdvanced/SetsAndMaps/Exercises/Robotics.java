package SetsAndMaps.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokensOfRobots = reader.readLine().split(";");
        String[] robots = new String[tokensOfRobots.length];
        int[] processTime = new int[tokensOfRobots.length];
        int[] robotsCounter = new int[tokensOfRobots.length];
        for (int i = 0; i < tokensOfRobots.length; i++) {
            String[] tokens = tokensOfRobots[i].split("-");
            robots[i] = tokens[0];
            processTime[i] = Integer.valueOf(tokens[1]);
        }
        String[] timeTokens = reader.readLine().split(":");
        long h = Integer.parseInt(timeTokens[0]) * 60 * 60;
        long m = Integer.parseInt(timeTokens[1]) * 60;
        long s = Integer.parseInt(timeTokens[2]);
        long seconds = h + m + s;
        ArrayDeque<String> tasks = new ArrayDeque<>();
        String input = reader.readLine();
        while (! "End".equals(input)) {
            tasks.offer(input);
            input = reader.readLine();
        }
        while (! tasks.isEmpty()) {
            seconds++;
            for (int i = 0; i < robotsCounter.length; i++) {
                if (robotsCounter[i] > 0) {
                    robotsCounter[i]--;
                }
            }
            String currItem = tasks.poll();
            boolean isTaken = false;
            for (int i = 0; i < robotsCounter.length; i++) {
                if (robotsCounter[i] == 0) {
                    robotsCounter[i] = processTime[i];
                    System.out.printf("%s - %s %s%n", robots[i], currItem, convertingSecondsToHhMmSs(seconds));
                    isTaken = true;
                    break;
                }
            }
            if (! isTaken) {
                tasks.offer(currItem);
            }
        }

    }
    private static String convertingSecondsToHhMmSs(long sec) {
        long s = sec % 60;
        long m = (sec / 60)% 60;
        long h = (sec / 360) % 24;
        return String.format("[%02d:%02d:%02d]", h, m, s);
    }
}

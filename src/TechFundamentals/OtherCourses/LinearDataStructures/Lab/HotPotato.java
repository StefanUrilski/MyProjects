package OtherCourses.LinearDataStructures.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] players = reader.readLine().split("\\s+");
        int rotation = Integer.valueOf(reader.readLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String player : players) {
            queue.offer(player);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < rotation; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}

package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int size = Integer.valueOf(input[0]);
        int pollSize = Integer.valueOf(input[1]);
        int wantedNumber = Integer.valueOf(input[2]);
        ArrayDeque<Integer> queueOfNumbers = new ArrayDeque<>();
        String[] tokens = reader.readLine().split("\\s+");
        for (String token : tokens) {
            int curr = Integer.valueOf(token);
            queueOfNumbers.offer(curr);
        }
        boolean isPresent = true;
        for (int i = 0; i < pollSize; i++) {
            int curr = queueOfNumbers.poll();
            if (curr == wantedNumber) {
                isPresent = false;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < queueOfNumbers.size(); i++) {
            int temp = queueOfNumbers.poll();
            if (temp < min) {
                min = temp;
            }
            queueOfNumbers.offer(temp);
        }
        if (size == pollSize) {
            System.out.println(0);
        } else if (isPresent){
            System.out.println("true");
        } else {
            System.out.println(min);
        }
    }
}

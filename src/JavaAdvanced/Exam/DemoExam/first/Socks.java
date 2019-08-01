package Exam.DemoExam.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Socks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> leftSockQueue = new ArrayDeque<>();
        ArrayDeque<Integer> rightSockStack = new ArrayDeque<>();

        String[] StringLeft = reader.readLine().split("\\s+");
        String[] StringRight = reader.readLine().split("\\s+");

        for (String s : StringLeft) {
            leftSockQueue.offer(Integer.parseInt(s));
        }

        for (String s : StringRight) {
            rightSockStack.push(Integer.parseInt(s));
        }

        ArrayDeque<Integer> pairsQueue = new ArrayDeque<>();
        int max = -1;
        while (true) {
            if (leftSockQueue.isEmpty() || rightSockStack.isEmpty()) {
                break;
            }
            int left = leftSockQueue.peekLast();
            int right = rightSockStack.peekLast();

            if (left < right) {
                if (leftSockQueue.size() == 1) {
                    break;
                }
                leftSockQueue.pollLast();
                left = leftSockQueue.peekLast();

            }
            if (left > right) {
                int pair = left + right;
                pairsQueue.offer(pair);
                if (pair > max) {
                    max = pair;
                }
                leftSockQueue.pollLast();
                rightSockStack.pollLast();
            } else if (left == right){
                rightSockStack.pollLast();
                addingValue(leftSockQueue);
            }
        }
        System.out.println(max);
        for (Integer integer : pairsQueue) {
            System.out.print(integer + " ");
        }
    }

    private static ArrayDeque<Integer> addingValue(ArrayDeque<Integer> leftSockQueue) {
        if (!leftSockQueue.isEmpty()) {
            leftSockQueue.offer(leftSockQueue.pollLast() + 1);
        }
        for (int i = 0; i < leftSockQueue.size() - 1; i++) {
            leftSockQueue.offer(leftSockQueue.pollLast());
        }

        return leftSockQueue;
    }
}

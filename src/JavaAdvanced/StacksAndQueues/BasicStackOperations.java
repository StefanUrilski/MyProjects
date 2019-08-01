package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        int capacity = Integer.valueOf(input[0]);
        int popsCount = Integer.valueOf(input[1]);
        int numbToFind = Integer.valueOf(input[2]);
        String[] numb = reader.readLine().split("\\s+");
        ArrayDeque<Integer> numbersInStack = new ArrayDeque<>(capacity);
        for (String aNumb : numb) {
            numbersInStack.push(Integer.valueOf(aNumb));
        }
        for (int i = 0; i < popsCount; i++) {
            numbersInStack.pop();
        }
        boolean notASmallNumber = true;
        if (numbersInStack.contains(numbToFind)) {
            System.out.println("true");
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < numbersInStack.size(); i++) {
                if (numbersInStack.peek() < min) {
                    min = numbersInStack.pop();
                    notASmallNumber = false;
                } else {
                    numbersInStack.pop();
                }
            }
            if (notASmallNumber) {
                min = 0;
            }
            System.out.println(min);
        }
    }
}

package OtherCourses.LinearDataStructures.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class DecimalToBinaryConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(reader.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (num > 0) {
            if (num % 2 == 0) {
                stack.push(0);
            } else {
                stack.push(1);
            }
            num /= 2;
        }
        for (Integer i : stack) {
            System.out.print(stack.pop());
        }
    }
}

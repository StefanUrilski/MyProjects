package MultidimensionalArrays.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class ReverseNumbersStack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        ArrayDeque<Integer> numbersInStack = new ArrayDeque<>();
        for (String anInput : input) {
            numbersInStack.push(Integer.valueOf(anInput));
        }
        while (! numbersInStack.isEmpty()) {
            System.out.print(numbersInStack.pop() + " ");
        }
    }
}

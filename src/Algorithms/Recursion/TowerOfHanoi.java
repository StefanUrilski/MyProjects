package Algorithms.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class TowerOfHanoi {
    private static Stack<Integer> source;
    private static Stack<Integer> destination;
    private static Stack<Integer> spare;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int elements = Integer.valueOf(reader.readLine());

        source = new Stack<>();
        destination = new Stack<>();
        spare = new Stack<>();

        while (elements > 0) {
            source.push(elements);
            elements--;
        }

        movingParts();
    }

    private static void movingParts() {

        if (source.isEmpty() && spare.isEmpty()) {
            return;
        }

        moveIfCan(source.peek());
        moveIfCan(destination.peek());
        moveIfCan(spare.peek());
    }

    private static void moveIfCan(int currDisk) {
        if (destination.isEmpty() || destination.peek() > currDisk){
           // destination.push()
        }//TODO...
    }
}

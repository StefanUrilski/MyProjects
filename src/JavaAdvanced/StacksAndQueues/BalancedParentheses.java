package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> containerStack = new ArrayDeque<>();
        String[] tokens = reader.readLine().split("");

        for (String token : tokens) {
            if (token.equals("(") || token.equals("[") || token.equals("{")) {
                containerStack.push(token);
            } else {
                if (containerStack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                String curr = containerStack.pop();
                if (!(curr.equals("(") && token.equals(")") || curr.equals("[") && token.equals("]")
                        || curr.equals("{") && token.equals("}"))) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");


    }
}

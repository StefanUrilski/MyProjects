package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfOperations = Integer.valueOf(reader.readLine());

        String word = "";
        Deque<String> statesStack = new ArrayDeque<>();
        while (numberOfOperations-- > 0) {
            String[] input = reader.readLine().split("\\s+");

            switch (input[0]) {
                case "1":
                    statesStack.push(word);
                    word += input[1];
                    break;
                case "2":
                    statesStack.push(word);
                    int indexToDelete = Integer.valueOf(input[1]);
                    if (indexToDelete < word.length()) {
                        word = word.substring(0, word.length() - indexToDelete);
                    } else {
                        word = "";
                    }
                    break;
                case "3":
                    int indexToPrint = Integer.valueOf(input[1]);
                    indexToPrint--;
                    System.out.println(word.charAt(indexToPrint));
                    break;
                case "4":
                    word = statesStack.pop();
                    break;
            }


        }

    }
}

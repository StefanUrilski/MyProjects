package Exam.Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ClubParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.valueOf(reader.readLine());
        ArrayDeque<String> input = new ArrayDeque<>();
        String[] line = reader.readLine().split(" ");
        for (int i = 0; i < line.length; i++) {
            input.push(line[i]);
        }
        for (String s : input) {
            if (Character.isLetter(s.charAt(0))) {
                break;
            }
            input.pop();
        }
        int sum = 0;
        List<String> halls = new ArrayList<>();
        List<String> seats = new ArrayList<>();
        while (! input.isEmpty()) {
            String currStr = input.peek();
            if (Character.isLetter(currStr.charAt(0))) {
                halls.add(input.pop());
                continue;
            }
            int curr = Integer.valueOf(input.pop());
            if (! halls.isEmpty()) {
                if (sum + curr <= capacity) {
                    sum += curr;
                    seats.add(curr + "");
                } else {
                    input.push(currStr);
                    System.out.println(halls.remove(0) + " -> " + String.join(", ", seats));
                    seats.clear();
                    sum = 0;
                }
            }
        }

    }
}

package ZForExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChoreWars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int dishesTime = 0;
        int cleaningTime = 0;
        int laundryTime = 0;

        while (!input.equals("wife is happy")) {
            if (input.contains("<") && input.contains(">")) {
                String task = input.substring(input.indexOf("<") + 1, input.indexOf(">"));
                if (task.contains("<")) {
                    task = task.substring(task.indexOf("<") + 1);
                }
                boolean isValid = true;
                for (int i = 0; i < task.length(); i++) {
                    char curr = task.charAt(i);
                    if (Character.isDigit(curr) || Character.isLowerCase(curr)) {
                    } else {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    for (int i = 0; i < task.length(); i++) {
                        char curr = task.charAt(i);
                        if (Character.isDigit(curr)) {
                            dishesTime += curr - '0';
                        }
                    }
                }
            } else if (input.contains("[") && input.contains("]")) {
                String task = input.substring(input.indexOf("[") + 1, input.indexOf("]"));
                if (task.contains("[")) {
                    task = task.substring(task.indexOf("[") + 1);
                }
                boolean isValid = true;
                for (int i = 0; i < task.length(); i++) {
                    char curr = task.charAt(i);
                    if (Character.isDigit(curr) || Character.isUpperCase(curr)) {
                        isValid = true;
                    } else {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    for (int i = 0; i < task.length(); i++) {
                        if (Character.isDigit(task.charAt(i))) {
                            cleaningTime += task.charAt(i) - '0';
                        }
                    }
                }
            } else if (input.contains("{") && input.contains("}")) {
                String task = input.substring(input.indexOf("{") + 1, input.indexOf("}"));
                if (task.contains("{")) {
                    task = task.substring(task.indexOf("{") + 1);
                }
                for (int i = 0; i < task.length(); i++) {
                    if (Character.isDigit(task.charAt(i))) {
                        laundryTime += task.charAt(i) - '0';
                    }
                }
            }

            input = reader.readLine();
        }
        System.out.printf("Doing the dishes - %d min.%n", dishesTime);
        System.out.printf("Cleaning the house - %d min.%n", cleaningTime);
        System.out.printf("Doing the laundry - %d min.%n", laundryTime);
        System.out.printf("Total - %d min.%n", dishesTime + cleaningTime + laundryTime);
    }
}

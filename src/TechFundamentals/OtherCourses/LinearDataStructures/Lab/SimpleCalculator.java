package OtherCourses.LinearDataStructures.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        ArrayDeque<String> stackCalc = new ArrayDeque<>();
        Collections.addAll(stackCalc,input);
        while (stackCalc.size() > 1) {
            int tempSum = 0;
            int firstNumber = Integer.parseInt(stackCalc.pop());
            String operator = stackCalc.pop();
            int secondNumber = Integer.parseInt(stackCalc.pop());
            switch (operator) {
                case "+":
                    tempSum = firstNumber + secondNumber;
                    break;
                case "-":
                    tempSum = firstNumber - secondNumber;
                    break;
                case "*":
                    tempSum = firstNumber * secondNumber;
                    break;
                case "/":
                    tempSum = firstNumber / secondNumber;
                    break;
            }
            stackCalc.push(tempSum + "");
        }
        System.out.println(stackCalc.pop());
    }
}

package TechFundamentals.Methods.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharactersInRange {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char first = reader.readLine().charAt(0);
        char second = reader.readLine().charAt(0);

        printingBetweenTwoChars(first, second);
    }

    private static void printingBetweenTwoChars(char start, char end) {
        if (start > end) {
            char temp = start;
            start = end;
            end = temp;
        }
        for (char i = start; i < end - 1; i++) {
            start++;
            System.out.print(start + " ");
        }
    }
}

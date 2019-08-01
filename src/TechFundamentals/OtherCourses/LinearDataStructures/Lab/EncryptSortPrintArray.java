package OtherCourses.LinearDataStructures.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EncryptSortPrintArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(reader.readLine());

        int[] encryptedNames = new int[a];
        for (int i = 0; i < a; i++) {
            String input = reader.readLine();
            input = input.trim();
            int sum = 0;
            for (int j = 0; j < input.length(); j++) {
                char curr = input.charAt(j);
                char currToLower = input.toLowerCase().charAt(j);
                if (currToLower == 'a' || currToLower == 'e' || currToLower == 'i' || currToLower == 'o' || currToLower == 'u') {
                    sum += curr * input.length();
                } else {
                    sum += curr / input.length();
                }
            }
            encryptedNames[i] = sum;
        }
        Arrays.sort(encryptedNames);
        for (int i : encryptedNames) {
            System.out.println(i);
        }
    }
}

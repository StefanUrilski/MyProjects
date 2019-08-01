package TechFundamentals.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rotationNumber = Integer.parseInt(reader.readLine());
        for (int i = 0; i < rotationNumber; i++) {
            rotation(numbers);
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static void rotation(int[] numbers) {
        int temp = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            numbers[i - 1] = numbers[i];
        }
        numbers[numbers.length - 1] = temp;

    }
}

package TechFundamentals.OtherCourses.Lists.Exerscise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ExtractMiddleElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputNumbers = reader.readLine();
        int[] numbers = Arrays
                .stream(inputNumbers.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lengthArr = numbers.length;
        if (lengthArr == 1) {
            System.out.println("{ " + numbers[0] + " }");
        } else if (lengthArr % 2 == 0) {
            System.out.println(String.format("{ %d, %d }",numbers[lengthArr / 2 - 1],
                    numbers[lengthArr / 2]));
        } else {
            System.out.println(String.format("{ %d, %d, %d }",numbers[lengthArr / 2 - 1],
                    numbers[lengthArr / 2], numbers[lengthArr / 2 + 1]));
        }


    }
}

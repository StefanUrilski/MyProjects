package TechFundamentals.OtherCourses.Lists.Exerscise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers1 = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] numbers2 = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxSize = 0;
        int d = 0;
        int d1 = 0;
        int d2 = 0;

        if(numbers1.length > numbers2.length){
            maxSize = numbers1.length;
        } else{
            maxSize = numbers2.length;
        }
        int[] numbers = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            if (i >= numbers1.length) {
                if (d == numbers1.length || i == numbers1.length) {
                    d1 = 0;
                    d = 0;
                }
                d ++;
            } else if (i >= numbers2.length) {
                if (d == numbers2.length || i == numbers2.length) {
                    d2 = 0;
                    d = 0;
                }
                d ++;
            }
            numbers[i] = numbers1[d1] + numbers2[d2];
            System.out.print(numbers[i] + " ");
            d1 ++;
            d2 ++;
        }

    }
}

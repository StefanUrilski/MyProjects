package TechFundamentals.OtherCourses.Lists.Exerscise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArrayInt {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.valueOf(reader.readLine());
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = Integer.valueOf(reader.readLine());
        }
        for (int i = 0; i < arrSize / 2; i++) {
            int x = arr[i];
            arr[i] = arr[arrSize - 1 - i];
            arr[arrSize - 1 - i] = x;
        }
        for (int i = 0; i < arrSize; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}

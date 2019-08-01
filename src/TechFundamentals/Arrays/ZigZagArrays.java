package TechFundamentals.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ZigZagArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] first = new int[n];
        int[] second = new int[n];

        for (int i = 0; i < n; i++) {
            int[] temp = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (i % 2 == 0) {
                first[i] = temp[0];
                second[i] = temp[1];
            } else {
                first[i] = temp[1];
                second[i] = temp[0];
            }
            System.out.print(first[i] + " ");
        }
        System.out.println();
        for (int aSecond : second) {
            System.out.print(aSecond + " ");
        }

    }
}

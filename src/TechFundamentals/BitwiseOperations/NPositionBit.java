package TechFundamentals.BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NPositionBit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.valueOf(reader.readLine());
        int position = Integer.valueOf(reader.readLine());

        int shifted = number >> position;
        int result = shifted & 1;

        System.out.println(result);
    }
}

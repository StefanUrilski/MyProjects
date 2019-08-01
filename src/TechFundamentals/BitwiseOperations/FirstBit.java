package TechFundamentals.BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstBit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.valueOf(reader.readLine());
        int shifted = input >> 1;

        int result = shifted & 1;
        System.out.println(result);
    }
}

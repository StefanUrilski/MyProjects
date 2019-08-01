package MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class newDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int value = 1;
        for (int i = 0; i < 15; i++) {
            for (int j = 1; j < 16; j++) {
                System.out.print(value++ + " ");
            }
            System.out.println();
        }
    }
}

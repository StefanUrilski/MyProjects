package TechFundamentals.Methods.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NxNMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        constructMatrix(n);
    }

    private static void constructMatrix(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(constructRow(n));
        }
    }
    private static String constructRow(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += n + " ";
        }
        return result;
    }
}

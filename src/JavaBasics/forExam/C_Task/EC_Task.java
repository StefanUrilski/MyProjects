package forExam.C_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EC_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int width = 2 * n + 3;

        // Top
        for (int i = 1; i <= n; i++) {
            System.out.print(repeatStr("*", i));
            System.out.print("\\");
            System.out.print(repeatStr("-", width - 2 - (2 * i)));
            System.out.print("/");
            System.out.println(repeatStr("*", i));
        }
        // Middle
        for (int i = 0; i < n/3; i++) {
            System.out.print("|");
            System.out.print(repeatStr("*", n / 2 + i));
            System.out.print("\\");
            System.out.print(repeatStr("*", n - (i * 2)));
            System.out.print("/");
            System.out.print(repeatStr("*", n / 2 + i));
            System.out.println("|");
        }
        // Bottom
        for (int i = 1; i <= n; i++) {
            System.out.print(repeatStr("-", i));
            System.out.print("\\");
            System.out.print(repeatStr("*", width - 2 - (2 * i)));
            System.out.print("/");
            System.out.println(repeatStr("-", i));
        }

    }
    private static String repeatStr(String symbol, int length){
        String result = "";
        for (int i = 0; i < length; i++) {
            result += symbol;
        }
        return result;
    }
}

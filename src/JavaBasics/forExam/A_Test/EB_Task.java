package forExam.A_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EB_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int more = 0;
        int height = n * 3 + 2;
        int wight = n * 5;
    // Top
        System.out.print(repeatStr(".", n));
        System.out.print(repeatStr("*", n * 3));
        System.out.println(repeatStr(".", n));

        for (int i = 1; i < n; i++) {
            System.out.print(repeatStr(".", n - i));
            System.out.print("*");
            System.out.print(repeatStr(".", n * 3 + more));
            System.out.print("*");
            System.out.println(repeatStr(".", n - i));
            more +=2;
        }
    // Middle
        System.out.println(repeatStr("*", wight));
    // Bottom
        for (int i = 1; i <= height - (n + 2); i++) {
            System.out.print(repeatStr(".", i));
            System.out.print("*");
            System.out.print(repeatStr(".", wight - (i * 2 + 2)));
            System.out.print("*");
            System.out.println(repeatStr(".", i));
        }
    // Bottom - Bottom
        System.out.print(repeatStr(".", n * 2 + 1));
        System.out.print(repeatStr("*", wight - (n * 4 + 2)));
        System.out.println(repeatStr(".", n * 2 + 1));
    }
    private static String repeatStr(String symbol, int length){
        String result = "";
        for (int i = 0; i < length; i++) {
            result += symbol;
        }
        return result;
    }
}

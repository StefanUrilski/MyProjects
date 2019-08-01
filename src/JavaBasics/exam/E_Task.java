package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        int height = 2 * n + 7;
        int width = 4 * n + 11;
        int dotts = (width - (n * 2))/ 2;

        // Hat
        System.out.print(repeatStr(".", (width - (n * 2 + 3))/ 2));
        System.out.print(repeatStr("_", n));
        System.out.print("/|\\");
        System.out.print(repeatStr("_", n));
        System.out.println(repeatStr(".", (width - (n * 2 + 3))/ 2));
        System.out.print(repeatStr(".", (width - (n * 2 + 3))/ 2));
        System.out.print("/");
        System.out.print(repeatStr("-", n * 2 + 1));
        System.out.print("\\");
        System.out.println(repeatStr(".", (width - (n * 2 + 3))/ 2));
        // 1/4 Body
        for (int i = 1; i <= 3; i++) {
            System.out.print(repeatStr(".", dotts - i -1));
            System.out.print("/");
            System.out.print(repeatStr(".", n * 2 + 1 + i * 2));
            System.out.print("\\");
            System.out.println(repeatStr(".", dotts - i - 1));
        }
        // 2/4 Body
        System.out.print(repeatStr(".", n));
        System.out.print("/");
        System.out.print(repeatStr("_", width - (n * 2 + 2)));
        System.out.print("\\");
        System.out.println(repeatStr(".", n));
        // 3/4 Body
        for (int i = 1; i <= n - 2 ; i++) {
            System.out.print(repeatStr(".", n - i));
            System.out.print("/");
            System.out.print(repeatStr(".", width - (n * 2 + 2) + (i * 2)));
            System.out.print("\\");
            System.out.println(repeatStr(".", n - i));
        }
        // 4/4 Body
        for (int i = 0; i < 2; i++) {
            System.out.print(repeatStr(".", 1 - i));
            System.out.print("/");
            System.out.print(repeatStr("_", width - 4 + (i * 2)));
            System.out.print("\\");
            System.out.print(repeatStr(".", 1 - i));
            System.out.println();
        }
        // Handle
        for (int i = 0; i < n; i++) {
            System.out.print(repeatStr(".", (width / 2) - 1));
            System.out.print("|$|");
            System.out.println(repeatStr(".", (width / 2) - 1));
        }
        // Bottom
        System.out.print("....");
        System.out.print(repeatStr("_", n * 2));
        System.out.print("|$|");
        System.out.print(repeatStr("_", n * 2));
        System.out.println("....");
        System.out.print(".../");
        System.out.print(repeatStr("_", n * 4 + 3));
        System.out.println("\\...");
    }
    private static String repeatStr(String symbol, int length){
        String result = "";
        for (int i = 0; i < length; i++) {
            result += symbol;
        }
        return result;
    }
}

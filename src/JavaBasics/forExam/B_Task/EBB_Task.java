package forExam.B_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EBB_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int wight = n * 5;
        int minuses = n * 3;
        int body = 0;
        int ddd = 0;
        // top
        for (int i = 0; i < n; i++) {
            System.out.print(repeatStr("-", n * 3));
            System.out.print("*");
            System.out.print(repeatStr("-", i));
            System.out.print("*");
            System.out.println(repeatStr("-", wight - minuses - 2 - i));
        }
        // Middle
        for (int i = 0; i < n/2; i++) {
            System.out.print(repeatStr("*", minuses + 1));
            System.out.print(repeatStr("-", n - 1));
            System.out.print("*");
            System.out.println(repeatStr("-", n - 1));
        }
        // Bottom
        for (int i = 0; i < n/2 - 1; i++) {
            body = n - 1;
            System.out.print(repeatStr("-", minuses));
            System.out.print("*");
            System.out.print(repeatStr("-", body + (i * 2)));
            System.out.print("*");
            System.out.println(repeatStr("-", n - 1 - i));
            minuses --;
        }
        // Bottom - Bottom
        ddd = n/2;
        if (n%2 == 0){} else{ ddd ++;}
        System.out.print(repeatStr("-", minuses));
        System.out.print(repeatStr("*", wight - ddd - minuses));
        System.out.println(repeatStr("-", ddd));
    }
    private static String repeatStr(String symbol, int length){
        String result = "";
        for (int i = 0; i < length; i++) {
            result += symbol;
        }
        return result;
    }
}

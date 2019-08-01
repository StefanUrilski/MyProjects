package forExam.D_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ED_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int width = 2 * n + 1;
        int height = 2 * n + 1;
        int points = 2;
        System.out.println(repeatStr("*", width));

        System.out.print(".*");
        System.out.print(repeatStr(" ", width - 4));
        System.out.println("*.");

        for (int i = 0; i < n - 2; i++) {
            System.out.print(repeatStr(".", points));
            System.out.print("*");
            System.out.print(repeatStr("@", width - (points * 2 + 2)));
            System.out.print("*");
            System.out.println(repeatStr(".", points));
            points ++;
        }

        // Middle
        System.out.print(repeatStr(".", points));
        System.out.print("*");
        System.out.println(repeatStr(".", points));

        for (int i = 0; i < n - 2; i++) {
            points --;
            System.out.print(repeatStr(".", points));
            System.out.print("*");
            System.out.print(repeatStr(" ", i));
            System.out.print("@");
            System.out.print(repeatStr(" ", i));
            System.out.print("*");
            System.out.println(repeatStr(".", points));
        }

        System.out.print(".*");
        System.out.print(repeatStr("@", width - 4));
        System.out.println("*.");
        System.out.println(repeatStr("*", width));
    }
    private static String repeatStr(String symbol, int length){
        String result = "";
        for (int i = 0; i < length; i++) {
            result += symbol;
        }
        return result;
    }
}

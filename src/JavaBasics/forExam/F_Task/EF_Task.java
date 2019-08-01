package forExam.F_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EF_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int height = 4 * n - 2;
        int width = 12 * n - 5;
        int outside = 0;
        int inside = 0;
        int down = 0;
        int test = 3 * (n - 1);

        System.out.print(repeatStr(".", width / 2));
        System.out.print("#");
        System.out.println(repeatStr(".", width / 2));

        for (int i = 0; i < height / 2 - 1; i++) {
            inside = 7 + ( 6 * i);
            outside = width / 2 - inside / 2;
            System.out.print(repeatStr(".", outside));
            System.out.print(repeatStr("#", inside));
            System.out.println(repeatStr(".", outside));
        }
        System.out.println(repeatStr("#", width));
        for (int i = 0; i < n - 2; i++) {
            down = 3 + (3 * i);
            System.out.print("|");
            System.out.print(repeatStr(".", down - 1));
            System.out.print(repeatStr("#", width - 6 - i * 6));
            System.out.println(repeatStr(".", down));
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print("|");
            System.out.print(repeatStr(".", test - 1));
            System.out.print(repeatStr("#", width - test * 2));
            System.out.println(repeatStr(".", test));
        }
        System.out.print("@");
        System.out.print(repeatStr(".", test - 1));
        System.out.print(repeatStr("#", width - test * 2));
        System.out.println(repeatStr(".", test));
    }
    private static String repeatStr(String symbol, int length){
        String result = "";
        for (int i = 0; i < length; i++) {
            result += symbol;
        }
        return result;
    }
}

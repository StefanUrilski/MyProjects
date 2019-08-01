import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class house {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        if (n % 2 == 0) {
            System.out.print(repeatStr("-", (n - 2)/2));
            System.out.print(repeatStr("*", 2));
            System.out.println(repeatStr("-",(n - 2)/2));
            for (int i = 0; i < ((n + 1) / 2) - 1; i++) {
                System.out.print(repeatStr("-", ((n-4)/2) - i));
                System.out.print(repeatStr("*", 4 + (i * 2)));
                System.out.print(repeatStr("-", ((n-4)/2) - i));
                System.out.println();
            }
        } else {
            System.out.print(repeatStr("-", (n - 1)/2));
            System.out.print(repeatStr("*", 1));
            System.out.println(repeatStr("-",(n - 1)/2));
            for (int i = 0; i < ((n + 1) / 2) - 1; i++) {
                System.out.print(repeatStr("-", ((n-3)/2) - i));
                System.out.print(repeatStr("*", 3 + (i * 2)));
                System.out.print(repeatStr("-", ((n-3)/2) - i));
                System.out.println();
            }
        }
        for (int i = 0; i < n / 2; i++) {
            System.out.print("|");
            System.out.print(repeatStr("*", n - 2));
            System.out.println("|");

        }
    }
    public static String repeatStr(String simbol, int lenght){
        String result = "";
        for (int i = 0; i < lenght; i++) {
            result += simbol;
        }
        return result;
    }
}

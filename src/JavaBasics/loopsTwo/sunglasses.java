import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sunglasses {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        System.out.print(repeatStr("*", n * 2));
        System.out.print(repeatStr(" ", n));
        System.out.println(repeatStr("*", n * 2));
        for (int i = 0; i < n - 2; i++) {
            System.out.print(repeatStr("*", 1));
            System.out.print(repeatStr("/", 2 * n - 2));
            System.out.print(repeatStr("*", 1));
            if (i == (n-1) / 2 - 1) {
                System.out.print(repeatStr("|", n));
            } else {
                System.out.print(repeatStr(" ", n));
            }
            System.out.print(repeatStr("*", 1));
            System.out.print(repeatStr("/", 2 * n - 2));
            System.out.println(repeatStr("*", 1));
        }
        System.out.print(repeatStr("*", n * 2));
        System.out.print(repeatStr(" ", n));
        System.out.println(repeatStr("*", n * 2));




    }
    public static String repeatStr(String simbol, int lenght){
        String result = "";
        for (int i = 0; i < lenght; i++) {
            result += simbol;
        }
        return result;
    }
}

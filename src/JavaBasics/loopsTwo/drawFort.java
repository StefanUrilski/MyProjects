import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class drawFort {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        System.out.print("/");
        System.out.print(repeatStr("^", n / 2));
        System.out.print("\\");
        System.out.print(repeatStr("_", (n*2)-(n/2)*2 -4));
        System.out.print("/");
        System.out.print(repeatStr("^", n / 2));
        System.out.println("\\");
        for (int i = 0; i < n - 3; i++) {
            System.out.print("|");
            System.out.print(repeatStr(" ", n * 2 - 2));
            System.out.println("|");
        }
        System.out.print("|");
        System.out.print(repeatStr(" ", n / 2 + 1));
        System.out.print(repeatStr("_", (n*2)-(n/2)*2 -4));
        System.out.print(repeatStr(" ", n / 2 + 1));
        System.out.println("|");
        System.out.print("\\");
        System.out.print(repeatStr("_", n / 2));
        System.out.print("/");
        System.out.print(repeatStr(" ", (n*2)-(n/2)*2 -4));
        System.out.print("\\");
        System.out.print(repeatStr("_", n / 2));
        System.out.println("/");
    }
    private static String repeatStr(String simbol, int lenght){
        String result = "";
        for (int i = 0; i < lenght; i++) {
            result += simbol;
        }
        return result;
    }
}
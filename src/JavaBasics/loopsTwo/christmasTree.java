import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class christmasTree {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i <= n; i++) {
            String stars = repeatStr("*", i);
            String spaces = repeatStr(" ", n - i);
            System.out.print(spaces);
            System.out.print(stars);
            System.out.print(" | ");
            System.out.print(stars);
            System.out.println(spaces);
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



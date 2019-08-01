import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class squareFrame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
           if (i == 0 || i == n - 1){
               System.out.print("+ ");
               for (int j = 0; j < n - 2; j++) {
                   System.out.print("- ");
               }
               System.out.println("+");
           } else {
               System.out.print("| ");
               for (int j = 0; j < n - 2; j++) {
                   System.out.print("- ");
               }
               System.out.println("|");
           }


        }
    }
}

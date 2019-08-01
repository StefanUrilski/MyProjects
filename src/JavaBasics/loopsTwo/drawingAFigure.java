import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class drawingAFigure {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            System.out.print("*");
            for (int j = 1; j < n; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}

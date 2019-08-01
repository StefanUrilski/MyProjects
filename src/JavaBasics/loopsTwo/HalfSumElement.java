import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HalfSumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int num = 0;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(reader.readLine());
            sum += num;
            if (num > max) {
                max = num;
            }
        }
        if ((sum-max) == max) {
            System.out.println("Yes");
            System.out.println("Sum = " + max);
        } else {
            System.out.println("No\nDiff = " + Math.abs(max - (sum - max)));
        }

    }
}

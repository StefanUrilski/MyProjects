package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RecursiveFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(reader.readLine());
        List<Long> fibonacci = new ArrayList<>();
        if (a == 0) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < a; i++) {
            if (i < 2) {
                long add = 1;
                fibonacci.add(add);
            } else {
                long temp = fibonacci.get(i - 1) + fibonacci.get(i - 2);
                fibonacci.add(temp);
            }
        }
        System.out.println(fibonacci.get(a - 1));
    }
}

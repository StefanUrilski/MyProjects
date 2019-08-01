package TechModule.JavaIntroductions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintAndSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int startNumber = Integer.valueOf(reader.readLine());
        int endNumber = Integer.valueOf(reader.readLine());

        int sum = 0;
        for (int i = startNumber; i <= endNumber; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println("\nSum: " + sum);
    }
}

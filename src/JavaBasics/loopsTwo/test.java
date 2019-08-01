import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int third = n % 10;
        n /= 10;
        int second = n % 10;
        n /= 10;
        int first = n % 10;
        System.out.println(third);
        System.out.println(second);
        System.out.println(first);
        double price = 22.5796;
        System.out.printf("price is %.2f ", price);
    }
}
/*
        var numCopy = num;
		var digit3 = numCopy % 10;
		numCopy /= 10;
		var digit2 = numCopy % 10;
		numCopy /= 10;
		var digit1 = numCopy % 10;
 */
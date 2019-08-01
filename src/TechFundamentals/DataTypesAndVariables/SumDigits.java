package TechModule.DataTypesAndVariables;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class SumDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputNumber = reader.readLine();

        int number = Integer.parseInt(inputNumber);
        int sum = 0;
        for (int i = 0; i < inputNumber.length(); i++) {
            int last = number % 10;
            number /= 10;
            sum += last;
        }
        System.out.println(sum);

    }
}

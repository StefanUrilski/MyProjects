package TechFundamentals.StringsAndTextProcessing.Exercise;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expression = reader.readLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char curr = expression.charAt(i);
            int temp  = (int) curr;
            temp += 3;
            char shiftedChar = (char) temp;
            result.append(shiftedChar);
        }
        System.out.println(result);
    }
}

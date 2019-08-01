package TechFundamentals.StringsAndTextProcessing.Lab;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class ReverseStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        while (!word.equals("end")) {
            StringBuilder builder = new StringBuilder();
            for (int i = word.length() - 1; i >= 0 ; i--) {
                builder.append(word.charAt(i));
            }
            System.out.println(word + " = " + builder);
            word = reader.readLine();
        }

    }
}

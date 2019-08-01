package TechFundamentals.StringsAndTextProcessing.Lab;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class RepeatString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        StringBuilder builder = new StringBuilder();
        for (String anInput : input) {
            for (int j = 0; j < anInput.length(); j++) {
                builder.append(anInput);
            }
        }
        System.out.println(builder);

    }
}

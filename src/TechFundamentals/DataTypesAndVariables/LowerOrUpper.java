package TechModule.DataTypesAndVariables;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class LowerOrUpper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        if (input.charAt(0) < 'A' || input.charAt(0) > 'Z'){
            System.out.println("lower-case");
        } else {
            System.out.println("upper-case");
        }

    }
}

package TechModule.DataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharToString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String result = "";
        for (int i = 0; i < 3; i++) {
            String input = reader.readLine();
            result += input;
        }
        System.out.println(result);
    }
}

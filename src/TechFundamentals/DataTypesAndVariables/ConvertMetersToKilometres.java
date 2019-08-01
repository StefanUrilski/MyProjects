package TechModule.DataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertMetersToKilometres {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double number = Double.valueOf(reader.readLine()) / 1000;

        System.out.println(String.format("%.2f",number));
    }
}

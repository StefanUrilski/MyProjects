package TechFundamentals.Methods.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataTypes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dataType = reader.readLine();
        switch (dataType) {
            case "int":
                int integer = Integer.parseInt(reader.readLine());
                modifyData(integer);
                break;
            case "real":
                double decimal = Double.parseDouble(reader.readLine());
                modifyData(decimal);
                break;
            case "string":
                String string = reader.readLine();
                modifyData(string);
                break;
            default:
                System.out.println("Wrong action! Try again.");
                break;
        }
    }

    private static void modifyData(String string) {
        System.out.println("$" + string + "$");
    }

    private static void modifyData(double number) {
        System.out.println(String.format(("%.2f"), number * 1.5));
    }

    private static void modifyData(int number) {
        System.out.println(number * 2);
    }
}

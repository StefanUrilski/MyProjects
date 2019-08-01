package TechFundamentals.Methods.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GreaterOfTwoValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dataType = reader.readLine();

        switch (dataType) {
            case "int": {
                int value1 = Integer.parseInt(reader.readLine());
                int value2 = Integer.parseInt(reader.readLine());
                getMax(value1, value2);
                break;
            }
            case "char": {
                char value1 = reader.readLine().charAt(0);
                char value2 = reader.readLine().charAt(0);
                getMax(value1, value2);
                break;
            }
            case "string": {
                String value1 = reader.readLine();
                String value2 = reader.readLine();
                getMax(value1, value2);
                break;
            }
            default:
                System.out.println("Wrong input! Please try again.");
                break;
        }
    }


    private static void getMax(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) {
            System.out.println();
        } else if (secondNumber > firstNumber) {
            System.out.println(secondNumber);
        }
    }

    private static void getMax(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            System.out.println(firstChar);
        }if (secondChar > firstChar) {
            System.out.println(secondChar);
        }
    }

    private static void getMax(String firstString, String secondString) {
        if (firstString.compareTo(secondString) > 0) {
            System.out.println(firstString);
        }
        System.out.println(secondString);
    }
}
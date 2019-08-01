package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pizza = reader.readLine();
        String type = reader.readLine();
        String sauce = reader.readLine();
        int amount = Integer.valueOf(reader.readLine());

        double orderPrice = 0;
        double small = 0;
        double large = 0;

        switch (pizza) {
            case "with meat":
                small += 7.5;
                large += 11;
                break;
            case "vegetarian":
                small += 5.5;
                large += 7.2;
                break;
            case "vegan":
                small += 3.9;
                large += 5.45;
                break;
            default:
                break;
        }
        if (sauce.equals("tomato")) {
            small += 1.5;
            large += 1.5;
        } else if (sauce.equals("garlic")) {
            small += 1.7;
            large += 1.7;
        } else if (sauce.equals("special")) {
            small += 2.5;
            large += 2.5;
        }
        switch (type) {
            case "small":
                orderPrice = small * amount;
                System.out.printf("%.2flv.", orderPrice);
                break;
            case "big":
                orderPrice = large *amount;
                System.out.printf("%.2flv.", orderPrice);
                break;
        }

    }
}

package TechModule.JavaIntroductions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vacation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int groupCount = Integer.valueOf(reader.readLine());
        String type = reader.readLine();
        String day = reader.readLine();

        double price = 0;
        if (day.equals("Friday")){
            if (type.equals("Students")){
                price = 8.45;
            } else if (type.equals("Business")){
                price = 10.90;
            } else if (type.equals("Regular")){
                price = 15;
            }
        } else if (day.equals("Saturday")){
            if (type.equals("Students")){
                price = 9.8;
            } else if (type.equals("Business")){
                price = 15.60;
            } else if (type.equals("Regular")){
                price = 20;
            }
        } else if (day.equals("Sunday")){
            if (type.equals("Students")){
                price = 10.46;
            } else if (type.equals("Business")){
                price = 16;
            } else if (type.equals("Regular")){
                price = 22.5;
            }
        }
        if (type.equals("Students") && groupCount >= 30) {
            price *= 0.85;
        } else if (type.equals("Business") && groupCount >= 100) {
            groupCount -= 10;
        } else if (type.equals("Regular") && groupCount >= 10 && groupCount <= 20) {
            price *= 0.95;
        }
        price *= groupCount;

        System.out.println(String.format("Total price: %.2f", price));
    }
}

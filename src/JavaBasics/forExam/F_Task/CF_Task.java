package forExam.F_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        int hoursSpent = Integer.valueOf(reader.readLine());
        int people = Integer.valueOf(reader.readLine());
        String timeOfDay = reader.readLine();

        double price = 0;
        switch (month) {
            case "january":
            case "february":
            case "march":
            case "april":
            case "may":
                if (timeOfDay.equals("day")) {
                    price += 10.5;
                } else {
                    price += 8.4;
                }
                break;
            case "june":
            case "july":
            case "august":
            case "september":
            case "october":
            case "november":
            case "december":
                if (timeOfDay.equals("day")) {
                    price += 12.6;
                } else {
                    price += 10.2;
                }
                break;
                default:
                    break;
        }
        if (people > 3) {
            price -= price * 0.1;
        }
        if (hoursSpent > 4) {
            price -= price * 0.5;
        }
        double cost = price * hoursSpent * people;
        System.out.printf("Price per person for one hour: %.2f \n", price);
        System.out.printf("Total cost of the visit: %.2f", cost);

        /*
        double budget = Double.valueOf(reader.readLine());
        String season = reader.readLine();

        double cabrio = 0;
        double jeep = 0;

        if (budget > 0 && budget <= 100) {
            System.out.println("Economy class");
            if (season.equals("Summer")){
                cabrio += budget * 0.35;
                System.out.printf("Cabrio - %.2f", cabrio);
            } else if (season.equals("Winter")){
                jeep += budget * 0.65;
                System.out.printf("Jeep - %.2f", jeep);
            }
        } else if (budget > 100 && budget <= 500) {
            System.out.println("Compact class");
            if (season.equals("Summer")){
                cabrio += budget * 0.45;
                System.out.printf("Cabrio - %.2f", cabrio);
            } else if (season.equals("Winter")){
                jeep += budget * 0.8;
                System.out.printf("Jeep - %.2f", jeep);
            }
        } else {
            jeep += budget * 0.9;
            System.out.println("Luxury class");
            System.out.printf("Jeep - %.2f", jeep);
        }
*/

    }
}

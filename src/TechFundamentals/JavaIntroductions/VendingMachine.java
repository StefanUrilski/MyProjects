package TechModule.JavaIntroductions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VendingMachine {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;

        while (true) {
            String coinsInput = reader.readLine();
            if (coinsInput.equals("Start")) {
                break;
            }
            double coins = Double.parseDouble(coinsInput);
            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
                sum += coins;
            } else {
                System.out.println(String.format("Cannot accept %.2f", coins));
            }
        }
        while (true){
            String products = reader.readLine();
            if (products.equals("End")){
                System.out.println(String.format("Change: %.2f", sum));
                break;
            }
            switch (products) {
                case "Nuts":
                    if (sum < 2) {
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    sum -= 2;
                    System.out.println("Purchased Nuts");
                    break;
                case "Water":
                    if (sum < 0.7) {
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    sum -= 0.7;
                    System.out.println("Purchased Water");
                    break;
                case "Crisps":
                    if (sum < 1.5) {
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    sum -= 1.5;
                    System.out.println("Purchased Crisps");
                    break;
                case "Soda":
                    if (sum < 0.8) {
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    sum -= 0.8;
                    System.out.println("Purchased Soda");
                    break;
                case "Coke":
                    if (sum < 1) {
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    sum -= 1;
                    System.out.println("Purchased Coke");
                    break;
                    default:
                        System.out.println("Invalid product");
            }
        }
    }
}

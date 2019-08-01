package forExam.F_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DF_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
/*        double a = Double.valueOf(reader.readLine());
        double result = 0;
        double middle = 0;
        double count1 = 0;
        double count2 = 0;
        double count3 = 0;
        double count4 = 0;
        double count5 = 0;
        double count6 = 0;
        for (int i = 0; i < a; i++) {
            int n = Integer.valueOf(reader.readLine());
            if (n < 0 || n > 50) {
                result /= 2;
                count6 ++;
            } else if (n < 10) {
                middle = n * 0.2;
                result += middle;
                count1 ++;
            } else if (n < 20) {
                middle = n * 0.3;
                result += middle;
                count2 ++;
            } else if (n < 30) {
                middle = n * 0.4;
                result += middle;
                count3 ++;
            } else if (n < 40) {
                middle = 50;
                result += middle;
                count4 ++;
            } else if (n <= 50) {
                middle = 100;
                result += middle;
                count5 ++;
            }
        }
        count1 = (count1 / a) * 100;
        count2 = (count2 / a) * 100;
        count3 = (count3 / a) * 100;
        count4 = (count4 / a) * 100;
        count5 = (count5 / a) * 100;
        count6 = (count6 / a) * 100;

        System.out.printf("%.2f\n",result);
        System.out.printf("From 0 to 9: %.2f", count1);
        System.out.println("%");
        System.out.printf("From 10 to 19: %.2f", count2);
        System.out.println("%");
        System.out.printf("From 20 to 29: %.2f", count3);
        System.out.println("%");
        System.out.printf("From 30 to 39: %.2f", count4);
        System.out.println("%");
        System.out.printf("From 40 to 50: %.2f", count5);
        System.out.println("%");
        System.out.printf("Invalid numbers: %.2f", count6);
        System.out.println("%");
*/
        int width = Integer.valueOf(reader.readLine());
        int length = Integer.valueOf(reader.readLine());
        int height = Integer.valueOf(reader.readLine());

        int amountPS = 0;
        int diff = 0;
        int room = width * length * height;

        while (true) {
            String amount = reader.readLine();
            if (amount.equals("Done")) {
                break;
            }
            amountPS += Integer.valueOf(amount);
            if (room < amountPS) {
                diff = amountPS - room;
                System.out.println("No more free space! You need " + diff + " Cubic meters more.");
                return;
            }
        }
        System.out.println(amountPS + " Cubic meters left.");
    }
}

package forExam.B_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CBB_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        int nightStay = Integer.valueOf(reader.readLine());
        double studio = 0;
        double apartment = 0;
        double discountS = 0;
        double discountA = 0;
        double allS = 0;
        double allA = 0;
        if (month.equals("May") || month.equals("October")) {
            studio += 50;
            apartment += 65;
            if (nightStay > 7 && nightStay < 14) {
                studio -= (studio * 0.05);
            } else if (nightStay > 14) {
                studio = studio - (studio * 0.3);
                apartment = apartment - (apartment * 0.1);
            }
        } else if (month.equals("June") || month.equals("September")) {
            studio += 75.2;
            apartment += 68.7;
            if (nightStay > 14) {
                studio = studio - (studio * 0.2);
                apartment = apartment - (apartment * 0.1);
            }
        } else if (month.equals("July") || month.equals("August")) {
            studio += 76;
            apartment += 77;
             if (nightStay > 14) {
                 apartment = apartment - (apartment * 0.1);
             }
        }
        allS = studio * nightStay;
        allA = apartment * nightStay;
        System.out.printf("Apartment: %.2f lv.", allA);
        System.out.println();
        System.out.printf("Studio: %.2f lv.", allS);
    }
}

package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(reader.readLine());
        int b = Integer.valueOf(reader.readLine());
        int c = Integer.valueOf(reader.readLine());
        int d = Integer.valueOf(reader.readLine());

        int none = 0;
        int three = 0;
        int four = 0;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                for (int k = 0; k <= c; k++) {
                    for (int l = 0; l <= d; l++) {
                        if (i == j && j == k && k == l) {
                            System.out.println("" + i + j + k + l);
                            four ++;
                        } else if (i == j && j == k || k == l && j == k) {
                            System.out.println("" + i + j + k + l);
                            three ++;
                        } else if (i == j && j == l || i == k && k == l || j == k || i == j || k == l
                                        || i == k || i == l || j == l){
                            System.out.println("" + i + j + k + l);
                            none ++;
                        } else if (i != j && i != k && i != l && j != k && j != l && k != l){
                            System.out.println("" + i + j + k + l);
                            none ++;
                        }
                    }
                }
            }
        }
        int moneyNone = none * 20;
        int moneyThree = three * 100;
        int moneyFour = four * 1000;
        int allMoney = moneyFour + moneyNone + moneyThree;
        System.out.printf("Final sum: %dlv.\n", allMoney);
        System.out.println("Car numbers with 3 equal digits: " + three);
        System.out.println("Car numbers with 4 equal digits: " + four);

    }
}

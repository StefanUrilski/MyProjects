package forExam.F_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AF_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /*
        double lengthA = Double.valueOf(reader.readLine());
        double heightB = Double.valueOf(reader.readLine());

        double side = lengthA * (lengthA / 2) * 2;
        double backSide1 = (lengthA / 2) * (lengthA / 2);
        double backSide2 = ((lengthA / 2) * (heightB - lengthA / 2)) / 2;
        double backSide = backSide1 + backSide2;
        double entrance = (lengthA / 5) * (lengthA / 5);
        double front = backSide - entrance;
        double allSides = side + backSide + front;

        double greenPaint = allSides / 3;
        double redPaint = side / 5;

        System.out.printf("%.2f\n",greenPaint);
        System.out.printf("%.2f",redPaint);
*/
        int n = Integer.valueOf(reader.readLine());

        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;
        int counter6 = 0;
        int sell3 = 0;
        int sell4 = 0;
        int sell5 = 0;
        int sell6 = 0;

        for (int i = 0; i < n; i++) {
            int a = Integer.valueOf(reader.readLine());
            int third = a % 10;
            int sells = a / 10;
            if (third == 2) {
                counter2 ++;
            } else if (third == 3) {
                counter3 ++;
                sell3 = sells;
            } else if (third == 4) {
                counter4 ++;
                sell4 = sells;
            } else if (third == 5) {
                counter5 ++;
                sell5 = sells;
            } else {
                counter6 ++;
                sell6 = sells;
            }
        }
        double sell = (counter3 * (sell3 * 0.5)) + (counter4 * (sell4 * 0.7))
                + (counter5 * (sell5 * 0.85)) + (counter6 * sell6);
        double rep1 = (counter2 * 2) + (counter3 * 3) + (counter4 * 4)
                + (counter5 * 5) + (counter6 * 6);
        double rep = rep1 / n;
        System.out.printf("%.2f\n", sell);
        System.out.printf("%.2f", rep);
    }
}

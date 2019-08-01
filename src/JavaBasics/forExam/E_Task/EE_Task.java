package forExam.E_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EE_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(reader.readLine());
        double averageScores = 0;
        double credits = 0;
        double credits1 = 0;
        double creditsAll = 0;
        for (int i = 0; i < a; i++) {
            int n = Integer.valueOf(reader.readLine());
            int score = n % 10;
            n /= 10;
            switch (score) {
                case 3:
                    credits = 0.5;
                    break;
                case 4:
                    credits = 0.7;
                    break;
                case 5:
                    credits = 0.85;
                    break;
                case 6:
                    credits = 1;
                    break;
                default:
                    credits = 0;
                    break;
            }
            credits1 = n * credits;
            creditsAll += credits1;
            averageScores += score;
        }
        averageScores /= a;
        System.out.printf("%.2f\n", creditsAll);
        System.out.printf("%.2f", averageScores);
    }
}
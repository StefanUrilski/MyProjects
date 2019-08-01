package forExam.A_Test;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class DB_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double money = Double.valueOf(reader.readLine());
        int year = Integer.valueOf(reader.readLine());
        int yearsOld = 19;
        for (int i = 1800; i <= year; i+=2) {
            money -= 12000;
        }
        for (int j = 1801; j <= year; j+=2) {
            money -= 12000 + yearsOld*50;
            yearsOld +=2;
        }
        if (year >= 1800) {
            if (money >= 0) {
                System.out.printf("Yes! He will live a carefree life " +
                        "and will have %.2f dollars left.", money);
            } else {
                System.out.printf("He will need %.2f dollars to survive.", Math.abs(money));
            }
        }
    }
}

package forExam.C_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FC_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int playerOne = Integer.valueOf(reader.readLine());
        int playerTwo = Integer.valueOf(reader.readLine());
        int maxFights = Integer.valueOf(reader.readLine());
        int count = 0;
        for (int i = 1; i <= playerOne ; i++) {
            for (int j = 1; j <= playerTwo; j++) {
                if (maxFights == count) break;
                System.out.print("(" + i + " <-> " + j + ")" + " ");
                count ++;
            }
        }

    }
}

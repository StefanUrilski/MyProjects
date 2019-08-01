package forExam.B_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FBB_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.valueOf(reader.readLine());
        int read = number;
        int third = read % 10;
        read /= 10;
        int second = read % 10;
        read /= 10;
        int first = read % 10;

        int row = first + second;
        int col = first + third;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (number % 5 == 0) {
                    number -= first;
                } else if (number % 3 == 0) {
                    number -= second;
                } else {
                    number += third;
                }
                System.out.print(number + " ");
            }
            System.out.println();

        }
    }
}

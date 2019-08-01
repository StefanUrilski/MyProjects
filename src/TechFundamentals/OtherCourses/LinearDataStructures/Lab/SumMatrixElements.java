package OtherCourses.LinearDataStructures.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumMatrixElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] rowAndCol = reader.readLine().split(",\\s+");
        int row = Integer.valueOf(rowAndCol[0]);
        int col = Integer.valueOf(rowAndCol[1]);

        int[][] matrix = new int[row][col];
        int sum = 0;
        for (int i = 0; i < row; i++) {
            String[] numbsAsStr = reader.readLine().split(",\\s+");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.valueOf(numbsAsStr[j]);
                sum += matrix[i][j];
            }
        }
        System.out.println(row);
        System.out.println(col);
        System.out.println(sum);

    }
}

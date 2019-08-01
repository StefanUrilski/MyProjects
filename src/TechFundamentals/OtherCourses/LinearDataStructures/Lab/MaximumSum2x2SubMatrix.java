package OtherCourses.LinearDataStructures.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSum2x2SubMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] rowAndCol = reader.readLine().split(",\\s+");
        int row = Integer.valueOf(rowAndCol[0]);
        int col = Integer.valueOf(rowAndCol[1]);
        int rowIndex = 0;
        int colIndex = 0;

        int[][] matrix = new int[row][col];
        int sum = 0;
        int bestSum = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            String[] values = reader.readLine().split(",\\s+");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Integer.valueOf(values[j]);
            }
        }
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                sum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (sum > bestSum) {
                    rowIndex = i;
                    colIndex = j;
                    bestSum = sum;
                }
            }
        }
        System.out.println(matrix[rowIndex][colIndex] + " " + matrix[rowIndex][colIndex + 1]);
        System.out.println(matrix[rowIndex + 1][colIndex] + " " + matrix[rowIndex + 1][colIndex + 1]);
        System.out.println(bestSum);
    }
}

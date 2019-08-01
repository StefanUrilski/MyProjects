package Exam.ExamPreparation.Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NatureProphet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = reader.readLine().split("\\s+");
        int n = Integer.valueOf(dimensions[0]);
        int m = Integer.valueOf(dimensions[1]);

        int[][] matrix = new int[n][m];

        String input = reader.readLine();

        while (! input.equals("Bloom Bloom Plow")) {
            String[] tokens = input.split("\\s+");
            int row = Integer.valueOf(tokens[0]);
            int col = Integer.valueOf(tokens[1]);

            blooming(row, col, matrix);
            matrix[row][col] -= 1;

            input = reader.readLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void blooming(int row, int col, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col]++;
            matrix[row][i]++;
        }
    }
}

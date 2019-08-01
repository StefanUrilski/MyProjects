package MultidimensionalArrays.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] pattern = reader.readLine().split(", ");
        int n = Integer.parseInt(pattern[0]);
        int[][] matrix = new int[n][n];
        int value = 1;
        if (pattern[1].equals("A")) {
            for (int col = 0; col < matrix.length; col++) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = value++;
                }
            }
        } else {
            for (int col = 0; col < matrix.length; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < matrix.length; row++) {
                        matrix[row][col] = value++;
                    }
                } else {
                    for (int row = matrix.length - 1; row >= 0; row--) {
                        matrix[row][col] = value++;
                    }
                }
            }
        }
        for (int[] rows : matrix) {
            System.out.println();
            for (int col : rows) {
                System.out.print(col + " ");
            }
        }
    }
}

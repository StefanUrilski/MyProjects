package MultidimensionalArrays.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] borders = reader.readLine().split("\\s+");
        int row = Integer.parseInt(borders[0]);
        int col = Integer.valueOf(borders[1]);

        int[][] matrix = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            String[] inputRowNumbers = reader.readLine().split("\\s+");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Integer.valueOf(inputRowNumbers[j]);
            }
        }
        int bestSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[0].length - 2; j++) {
                int firstRow = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2];
                int secondRow = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2];
                int thirdRow = matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                int sum = firstRow + secondRow + thirdRow;
                if (sum > bestSum) {
                    bestSum = sum;
                    bestRow = i;
                    bestCol = j;
                }
            }
        }
        System.out.println("Sum = " + bestSum);
        System.out.printf("%d %d %d%n", matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1], matrix[bestRow][bestCol + 2]);
        System.out.printf("%d %d %d%n", matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1], matrix[bestRow + 1][bestCol + 2]);
        System.out.printf("%d %d %d%n", matrix[bestRow + 2][bestCol], matrix[bestRow + 2][bestCol + 1], matrix[bestRow + 2][bestCol + 2]);


    }
}

package MultidimensionalArrays.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.valueOf(reader.readLine());
        int primarySumDiagonal = 0;
        int secondarySumDiagonal = 0;
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int row = size - 1;

        for (int i = 0; i < size; i++) {
            primarySumDiagonal += matrix[i][i];
            secondarySumDiagonal += matrix[row--][i];
        }

        System.out.println(Math.abs(primarySumDiagonal - secondarySumDiagonal));
    }
}

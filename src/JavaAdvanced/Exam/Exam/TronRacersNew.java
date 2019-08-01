package Exam.Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TronRacersNew {
    private static char[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.valueOf(reader.readLine());

        matrix = new char[rows][];
        int[] rowAndColFirst = new int[2];
        int[] rowAndColSecond = new int[2];

        for (int row = 0; row < rows; row++) {
            matrix[row] = reader.readLine().toCharArray();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'f') {
                    rowAndColFirst[0] = row;
                    rowAndColFirst[1] = col;
                }
                if (matrix[row][col] == 's') {
                    rowAndColSecond[0] = row;
                    rowAndColSecond[1] = col;
                }
            }
        }

        while (true) {

        }
    }
}

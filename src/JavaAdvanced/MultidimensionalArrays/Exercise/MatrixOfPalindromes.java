package MultidimensionalArrays.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] rowsAndCols = reader.readLine().split("\\s+");
        int row = Integer.valueOf(rowsAndCols[0]);
        int col = Integer.valueOf(rowsAndCols[1]);

        String[][] matrix = new String[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char startAndEnd = (char)('a' + i);
                char middle = (char)(startAndEnd + j);
                matrix[i][j] = String.valueOf(startAndEnd) + middle + startAndEnd;
            }
        }
        for (String[] rows : matrix) {
            System.out.println();
            for (String items : rows) {
                System.out.print(items + " ");
            }
        }
    }
}

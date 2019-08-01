package MultidimensionalArrays.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = reader.readLine().split("\\s+");
        if (size.length != 2) {
            return;
        }
        if (!Character.isDigit(size[0].charAt(0)) || !Character.isDigit(size[1].charAt(0))) {
            return;
        }
        int row = Integer.valueOf(size[0]);
        int col = Integer.valueOf(size[1]);

        String[][] matrix = new String[row][col];

        for (String[] aMatrix : matrix) {
            String[] tokens = reader.readLine().split("\\s+");
            System.arraycopy(tokens, 0, aMatrix, 0, matrix[0].length);
        }
        String input;
        while (! "END".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            if (! input.startsWith("swap") || tokens.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }
            int fromRow = Integer.valueOf(tokens[1]);
            int fromCol = Integer.valueOf(tokens[2]);
            int toRow = Integer.valueOf(tokens[3]);
            int toCol = Integer.valueOf(tokens[4]);
            if (fromRow > row || toRow > row || fromCol > col || toCol > col || !tokens[0].equals("swap")
                    || fromRow < 0 || toRow < 0 || fromCol < 0 || toCol < 0) {
                System.out.println("Invalid input!");
                continue;
            }
            String temp = matrix[fromRow][fromCol];
            matrix[fromRow][fromCol] = matrix[toRow][toCol];
            matrix[toRow][toCol] = temp;
            for (String[] rows : matrix) {
                for (String items : rows) {
                    System.out.print(items + " ");
                }
                System.out.println();
            }
        }
    }
}

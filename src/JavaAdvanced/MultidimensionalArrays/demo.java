package MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class demo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        ArrayList<List<Integer>> matrix = new ArrayList<>(rows);

        int value = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                matrix.get(row).add(value++);
            }
        }

        String line = reader.readLine();

        while (!line.equals("Nuke it from orbit")) {
            String[] tokens = line.split("\\s+");
            int rowIndex = Integer.valueOf(tokens[0]);
            int colIndex = Integer.valueOf(tokens[1]);
            int radius = Integer.valueOf(tokens[2]);
            if (rowIndex < rows && colIndex < cols && rowIndex >= 0 && colIndex >= 0) {
                detonatingTheBomb(rowIndex, colIndex, radius, matrix);
            }

            line = reader.readLine();
        }

        printingTheMatrix(matrix);
    }

    private static void printingTheMatrix(List<List<Integer>> matrix) {
        for (List<Integer> integers : matrix) {
            boolean isEmpty = true;
            for (Integer integer : integers) {
                System.out.print(integer + " ");
                isEmpty = false;
            }
            if (!isEmpty) {
                System.out.println();
            }
        }
    }

    private static void detonatingTheBomb(int rowIndex, int colIndex, int blastRadius, List<List<Integer>> matrix) {

        int radius = blastRadius;
        int temp = 1;
        for (int col = matrix.get(rowIndex).size() - 1; col >= 0; col--) {
            if (rowIndex + 1 == col && radius > 0) {
                matrix.get(rowIndex).remove(col);
                radius--;
            } else if (rowIndex == col) {
                matrix.get(rowIndex).remove(rowIndex);
                radius = blastRadius;
            } if (rowIndex - temp == col && radius > 0) {
                matrix.get(rowIndex).remove(col);
                temp++;
                radius--;
            }
        }

        radius = blastRadius;
        for (int row = 0; row < matrix.get(row).size(); row++) {
            if (rowIndex - radius < 0) {
                radius--;
                row--;
            } else if (row == rowIndex - radius) {
                matrix.get(row).remove(colIndex);
                radius--;
            } else if (row == rowIndex) {
                matrix.get(rowIndex).remove(colIndex);
            } else if (row == rowIndex - 1 && blastRadius > 0) {
                matrix.get(row).remove(colIndex);
                blastRadius--;
            }
        }

//        while (end-- > 0) {
//            if (col >= 0 && col < matrix.get(rowIndex).getRows()) {
//                matrix.get(rowIndex).remove(col);
//                col--;
//            }
//            if (row >= 0 && matrix.getRows() > row && row < matrix.get(row).getRows()) {
//                matrix.get(row).remove(colIndex);
//            }
//            col++; row++;
//        }
    }
}

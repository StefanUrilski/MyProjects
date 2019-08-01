package Algorithms.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConnectedAreasInMatrix {
    private static int blocks;
    private static String[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int r = Integer.valueOf(reader.readLine());
        int c = Integer.valueOf(reader.readLine());

        int row;
        int col;
        matrix = new String[r][c];

        for (int i = 0; i < r; i++) {
            matrix[i] = reader.readLine().split("");
        }
        Map<String, Integer> count = new LinkedHashMap<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j].equals("-")) {
                    row = i;
                    col = j;
                    blocks = 0;
                    searchAndCountTheMatrix(row, col);
                    String coordinates = "(" + row + ", " + col + ")";
                    count.put(coordinates, blocks);
                }
            }
        }
        Map<String, Integer> sorted = new LinkedHashMap<>();
        int counter = 1;

        count.entrySet().stream().sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                .forEach(e -> sorted.put(e.getKey(), e.getValue()));

        System.out.println("Total areas found: " + count.size());
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.printf("Area #%d at %s, getRows: %d%n", counter++, entry.getKey(), entry.getValue());
        }
    }

    private static void searchAndCountTheMatrix(int row, int col) {

        if (row < 0 || col < 0 || row == matrix.length || col == matrix[row].length
                || matrix[row][col].equals("*") || matrix[row][col].equals("+")) {
            return;
        }

        blocks++;
        matrix[row][col] = "+";
        searchAndCountTheMatrix(row - 1, col);
        searchAndCountTheMatrix(row, col + 1);
        searchAndCountTheMatrix(row  + 1, col);
        searchAndCountTheMatrix(row, col - 1);
    }
}

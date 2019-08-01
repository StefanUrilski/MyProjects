package Algorithms.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PathsInLabyrinth {

    public static String[][] matrix;
    public static List<String> path = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.valueOf(reader.readLine());
        int cols = Integer.valueOf(reader.readLine());

        matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] tokens = reader.readLine().split("");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = tokens[col];
            }
        }

        findingThePath(0, 0, "");
    }

    private static void findingThePath(int row, int col, String direction) {
        if (outOfBoundsOrWall(row, col)) {
            return;
        }
        path.add(direction);
        if (matrix[row][col].equals("e")) {
            // FIXME: 09-Feb-19 SPACE!
            path.forEach(System.out::print);
            System.out.println();
            path.remove(path.size() - 1);
        } else {
            matrix[row][col] = "x";
            findingThePath(row - 1, col, "U");
            findingThePath(row, col + 1, "R");
            findingThePath(row + 1, col, "D");
            findingThePath(row, col - 1, "L");
            matrix[row][col] = "-";
            path.remove(path.size() - 1);
        }
    }

    private static boolean outOfBoundsOrWall(int row, int col) {
        return row < 0 || col < 0 || matrix.length == row || matrix[row].length == col
                || matrix[row][col].equals("*") ||  matrix[row][col].equals("x");
    }
}

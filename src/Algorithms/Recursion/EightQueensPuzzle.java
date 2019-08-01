package Algorithms.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EightQueensPuzzle {

    private static String[][] matrix;

    private static int[] queens;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        matrix = new String[8][8];
        queens = new int[8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = "-";
            }
        }
        
        placeTheQueens(0, 0);
        
    }

    private static void placeTheQueens(int row, int col) {
        if (outOfBounds(row, col)) {
            return;
        }
        if (checkPlace(row, col)) {

        }


    }

    private static boolean checkPlace(int row, int col) {
        return false;
    }

    private static boolean outOfBounds(int row, int col) {
        return row < 0 || col < 0 || matrix.length == row || matrix[row].length == col;
    }
}

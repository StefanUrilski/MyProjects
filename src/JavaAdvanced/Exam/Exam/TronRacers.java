package Exam.Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TronRacers {
    private static String[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        matrix = new String[n][];
        int[] rowAndColFirst = new int[2];
        int[] rowAndColSecond = new int[2];

        for (int i = 0; i < n; i++) {
            matrix[i] = reader.readLine().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("f")) {
                    rowAndColFirst[0] = i;
                    rowAndColFirst[1] = j;
                }
                if (matrix[i][j].equals("s")) {
                    rowAndColSecond[0] = i;
                    rowAndColSecond[1] = j;
                }
            }
        }

        while (true) {
            String[] directions = reader.readLine().split(" ");
            String firstMove = directions[0];
            String secondMove = directions[1];

            movingPlayer(firstMove, rowAndColFirst, "f");
            if (matrix[rowAndColFirst[0]][rowAndColFirst[1]].equals("sf")) {
                matrix[rowAndColFirst[0]][rowAndColFirst[1]] = "x";
                printTheMatrix();
                return;
            }
            movingPlayer(secondMove, rowAndColSecond, "s");
            if (matrix[rowAndColSecond[0]][rowAndColSecond[1]].equals("fs")) {
                matrix[rowAndColSecond[0]][rowAndColSecond[1]] = "x";
                printTheMatrix();
                return;
            }

        }

    }

    private static void printTheMatrix() {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void movingPlayer(String direction, int[] rowAndCol, String symbol) {
        switch (direction) {
            case "up":
                rowAndCol[0] -= 1;
                checkBoundsAndMove(rowAndCol);
                if (matrix[rowAndCol[0]][rowAndCol[1]].equals("*")) {
                    matrix[rowAndCol[0]][rowAndCol[1]] = symbol;
                } else {
                    matrix[rowAndCol[0]][rowAndCol[1]] += symbol;
                }
                break;
            case "right":
                rowAndCol[1] += 1;
                checkBoundsAndMove(rowAndCol);
                if (matrix[rowAndCol[0]][rowAndCol[1]].equals("*")) {
                    matrix[rowAndCol[0]][rowAndCol[1]] = symbol;
                } else {
                    matrix[rowAndCol[0]][rowAndCol[1]] += symbol;
                }
                break;
            case "down":
                rowAndCol[0] += 1;
                checkBoundsAndMove(rowAndCol);
                if (matrix[rowAndCol[0]][rowAndCol[1]].equals("*")) {
                    matrix[rowAndCol[0]][rowAndCol[1]] = symbol;
                } else {
                    matrix[rowAndCol[0]][rowAndCol[1]] += symbol;
                }
                break;
            case "left":
                rowAndCol[1] -= 1;
                checkBoundsAndMove(rowAndCol);
                if (matrix[rowAndCol[0]][rowAndCol[1]].equals("*")) {
                    matrix[rowAndCol[0]][rowAndCol[1]] = symbol;
                } else {
                    matrix[rowAndCol[0]][rowAndCol[1]] += symbol;
                }
                break;
        }

    }

    private static void checkBoundsAndMove(int[] rowAndCol) {
        int row = rowAndCol[0];
        int col = rowAndCol[1];

        if (row < 0) {
            rowAndCol[0] = matrix.length - 1;
        } else if (row == matrix.length) {
            rowAndCol[0] = 0;
        } else if (col < 0) {
            rowAndCol[1] = matrix[0].length - 1;
        } else if (col == matrix[0].length){
            rowAndCol[1] = 0;
        }
    }
}

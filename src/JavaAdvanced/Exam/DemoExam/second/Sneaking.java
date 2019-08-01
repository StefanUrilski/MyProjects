package Exam.DemoExam.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sneaking {
    private static int row;
    private static int col;
    private static char[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        matrix = new char[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = reader.readLine().toCharArray();
        }

        int[] enemy = findTings();

        char[] allDirections = reader.readLine().toCharArray();

        for (char direction : allDirections) {
            moveTheGuards();

            if (guardsSeesHim()) {
                System.out.printf("Sam died at %d, %d%n", row, col);
                matrix[row][col] = 'X';
                printTheMatrix();
                return;
            }

            switch (direction) {
                case 'U':
                    matrix[row][col] = '.';
                    row -= 1;
                    matrix[row][col] = 'S';
                    break;
                case 'D':
                    matrix[row][col] = '.';
                    row += 1;
                    matrix[row][col] = 'S';
                    break;
                case 'L':
                    matrix[row][col] = '.';
                    col -= 1;
                    matrix[row][col] = 'S';
                    break;
                case 'R':
                    matrix[row][col] = '.';
                    col += 1;
                    matrix[row][col] = 'S';
                    break;
            }

            if (row == enemy[0]) {
                System.out.println("Nikoladze killed!");
                matrix[enemy[0]][enemy[1]] = 'X';
                printTheMatrix();
                return;
            }
        }

    }

    private static int[] findTings() {
        int[] result = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'S') {
                    row = i;
                    col = j;
                }
                if (matrix[i][j] == 'N') {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    private static void printTheMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean guardsSeesHim() {
        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i] == 'b') {
                if (col > i) {
                    return true;
                }
            }
            if (matrix[row][i] == 'd') {
                if (col < i) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void moveTheGuards() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'b') {
                    if (col == matrix[row].length - 1){
                        matrix[row][col] = 'd';
                    } else {
                        matrix[row][col] = '.';
                        matrix[row][col + 1] = 'b';
                    }
                    break;
                } else if (matrix[row][col] == 'd') {
                    if (col == 0){
                        matrix[row][col] = 'b';
                    } else {
                        matrix[row][col] = '.';
                        matrix[row][col - 1] = 'd';
                    }
                    break;
                }
            }
        }

    }
}

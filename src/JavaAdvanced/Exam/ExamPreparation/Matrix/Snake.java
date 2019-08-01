package Exam.ExamPreparation.Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snake {
    private static int row;
    private static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        char[][] matrix = new char[n][n];

        String[] commands = reader.readLine().split(", ");

        int foodCount = 0;
        int snakeLength = 1;

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                char curr = tokens[j].charAt(0);
                matrix[i][j] = curr;
                if (curr == 'f') {
                    foodCount++;
                } else if (curr == 's') {
                    row = i;
                    col = j;
                }

            }
        }

        for (String command : commands) {
            moving(command, n);
            char curr = matrix[row][col];
            if (curr == 'f') {
                matrix[row][col] = '*';
                foodCount--;
                snakeLength++;
                if (foodCount == 0) {
                    System.out.println("You win! Final snake length is " + snakeLength);
                    return;
                }
            } else if (curr == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
        }
        System.out.printf("You lose! There is still %d food to be eaten.%n", foodCount);
    }

    private static void moving(String command, int sizes) {
        switch (command) {
            case "up":
                row--;
                break;
            case "down":
                row++;
                break;
            case "left":
                col--;
                break;
            case "right":
                col++;
                break;
        }

        if (col == sizes) {
            col = 0;
        } else if (col < 0) {
            col = sizes - 1;
        } else if (row == sizes) {
            row = 0;
        } else if (row < 0) {
            row = sizes - 1;
        }
    }
}

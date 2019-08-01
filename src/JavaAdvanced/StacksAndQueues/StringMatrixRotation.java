package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String findingTheRotation = reader.readLine();
        // finding the rotation degrees
        findingTheRotation = findingTheRotation.substring(findingTheRotation.indexOf("(") + 1, findingTheRotation.indexOf(")"));
        int rotation = Integer.valueOf(findingTheRotation);
        String input;
        List<String> wordLines = new ArrayList<>();
        int maxLength = 0;

        // reading words from the console
        while (!"END".equals(input = reader.readLine())) {
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            wordLines.add(input);
        }

        // filling the matrix
        String[][] matrix = new String[wordLines.size()][maxLength];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                String curr = wordLines.get(i);
                if (j >= curr.length()) {
                    matrix[i][j] = " ";
                } else {
                    matrix[i][j] = curr.charAt(j) + "";
                }
            }
        }

        String[][] rotatedMatrix;

        rotation = (rotation / 90) % 4;
        if (rotation == 0) {
            printingTheMatrix(matrix);
        }  else if (rotation == 1) {
            rotatedMatrix = new String[matrix[0].length][matrix.length];
            for (int j = 0; j < matrix[0].length; j++){
                int index = matrix.length;
                for (int i = 0; i < matrix.length; i++) {
                    index--;
                    rotatedMatrix[j][i] = matrix[index][j];
                }
            }
            printingTheMatrix(rotatedMatrix);
        } else if (rotation == 2) {
            rotatedMatrix = new String[matrix.length][matrix[0].length];
            int index = 0;
            for (int i = matrix.length - 1; i >= 0; i--) {
                int jIndex = 0;
                for (int j = matrix[0].length - 1; j >= 0; j--) {
                    rotatedMatrix[index][jIndex] = matrix[i][j];
                    jIndex++;
                }
                index++;
            }
            printingTheMatrix(rotatedMatrix);
        } else if (rotation == 3) {
            rotatedMatrix = new String[matrix[0].length][matrix.length];
            int index = 0;
            for (int j = matrix[0].length - 1; j >= 0; j--){
                for (int i = 0; i < matrix.length; i++) {
                    rotatedMatrix[index][i] = matrix[i][j];
                }
                index++;
            }
            printingTheMatrix(rotatedMatrix);
        }

    }
    private static void printingTheMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            for (String cols : rows) {
                System.out.print(cols);
            }
            System.out.println();
        }
    }
}

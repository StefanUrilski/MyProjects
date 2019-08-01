package Exam.ExamPreparation.Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Monopoly {
    private static int money;
    private static int hotels;
    private static int row;
    private static int col;
    private static String[][] matrix;
    private static int steps;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] field = reader.readLine().split("\\s+");

        matrix = new String[Integer.valueOf(field[0])][];
        money = 50;
        hotels = 0;
        row = 0;
        col = 0;
        steps = 0;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = reader.readLine().split("");
        }

        boolean notFinished = true;
        while (notFinished) {
            switch (matrix[row][col]) {
                case "H":
                    hotels++;
                    System.out.printf("Bought a hotel for %d. Total hotels: %d.%n", money, hotels);
                    money = 0;
                    break;
                case "J":
                    money = calcMoney();
                    money = calcMoney();
                    System.out.printf("Gone to jail at turn %d.%n", steps);
                    steps += 2;
                    break;
                case "S":
                    String result;
                    int spentMoney = (row + 1) * (col + 1);
                    if (money > spentMoney) {
                        money -= spentMoney;
                        result = "Spent " + (spentMoney) + " money at the shop.";
                    } else {
                        result = "Spent " + money + " money at the shop.";
                        money = 0;
                    }
                    System.out.println(result);
                    break;
            }
            money = calcMoney();
            notFinished = move();
        }

        System.out.println("Turns " + steps);
        System.out.println("Money " + money);

    }

    private static int calcMoney() {
        return money += hotels * 10;
    }

    private static boolean move() {
        evenRow();
        oddRow();
        steps++;
        return row < matrix.length;
    }

    private static void evenRow() {
        if (row % 2 == 0) {
            col++;
            if (col == matrix[0].length) {
                row++;
            }
        }
    }

    private static void oddRow() {
        if (row % 2 != 0) {
            col--;
            if (col < 0) {
                row++;
                evenRow();
            }
        }
    }
}

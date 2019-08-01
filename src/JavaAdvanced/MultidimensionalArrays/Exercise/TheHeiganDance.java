package MultidimensionalArrays.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheHeiganDance {

    private static int[][] matrix;
    private static int playerHealth;
    private static int spellRow;
    private static int spellCol;
    private static int lastCloudSpellRow;
    private static int lastCloudSpellCol;
    private static int row;
    private static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double dmgPerTurn = Double.valueOf(reader.readLine());

        matrix = new int[15][15];

        playerHealth = 18500;
        double bossHealth = 3000000;

        int[] position = {7, 7};

        boolean activeCloud = false;
        String spell = "";

        while (playerHealth >= 0) {
            if (activeCloud) {
                cloudSecondaryDMG();
            }
            bossHealth -= dmgPerTurn;
            if (bossHealth < 0 || playerHealth < 0) {
                break;
            }

            String[] line = reader.readLine().split("\\s+");
            spell = line[0];
            spellRow = Integer.valueOf(line[1]);
            spellCol = Integer.valueOf(line[2]);

            row = position[0];
            col = position[1];
            if (spell.equals("Cloud")) {

                // if it is in the blast radius
                if (checkArea(row, col)) {
                    if (tryingToMove(position)) {
                    } else {
                        playerHealth -= 3500;
                    }
                }
                activeCloud = true;
                lastCloudSpellRow = spellRow;
                lastCloudSpellCol = spellCol;

            } else {
                if (checkArea(row, col)) {
                    if (tryingToMove(position)) {
                    } else {
                        playerHealth -= 6000;
                    }
                }

                activeCloud = false;

            }

        }

        if (playerHealth > 0) {
            System.out.println("Heigan: Defeated!");
            System.out.println("Player: " + playerHealth);
        } else if (playerHealth < 0 && bossHealth < 0) {
            System.out.println("Heigan: Defeated!");
            System.out.println("Player: Killed by Plague Cloud");
        } else {
            System.out.println(String.format("Heigan: %.2f", bossHealth));
            if (spell.equals("Cloud")) {
                System.out.println("Player: Killed by Plague Cloud");
            } else {
                System.out.println("Player: Killed by Eruption");
            }
        }

        System.out.println(String.format("Final position: %d, %d", position[0], position[1]));

    }

    private static void cloudSecondaryDMG() {
        if (checkCloudArea(row, col)) {
            playerHealth -= 3500;
        }
    }

    private static boolean checkCloudArea(int row, int col) {

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (lastCloudSpellRow - 1 + r == row && lastCloudSpellCol - 1 + c == col) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkArea(int row, int col) {

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (spellRow - 1 + r == row && spellCol - 1 + c == col) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean tryingToMove(int[] position) {

        // it can't move
        if (position[0] == spellRow && position[1] == spellCol) {
            return false;
        }

        // move up
        if (row != 0 && !checkArea(row - 1, col)) {
            position[0]--;
            row = position[0];
            return true;
        }

        // move right
        if (col + 1 < matrix[row].length && !checkArea(row, col + 1)) {
            position[1]++;
            col = position[1];
            return true;
        }

        // move down
        if (row + 1 < matrix.length && !checkArea(row + 1, col)) {
            position[0]++;
            row = position[0];
            return true;
        }

        // move left
        if (col != 0 && !checkArea(row, col - 1)) {
            position[1]--;
            col = position[1];
            return true;
        }
        return false;
    }
}

package TechFundamentals.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LadyBugs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lengthOfFlight = Integer.valueOf(reader.readLine());
        String input = reader.readLine();

        String[] bugActions;
        int[] field = new int[lengthOfFlight];
        int[] fieldPositions = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int position : fieldPositions) {
            field[position] = 1;
        }

        input = reader.readLine();
        while (!input.equals("end")) {
            bugActions = input.split(" ");
            int fromPlace = Integer.parseInt(bugActions[0]);
            int toPlace = Integer.parseInt(bugActions[2]);
            switch (bugActions[1]) {
                case "right":
                    if ((fromPlace + toPlace) > lengthOfFlight - 1) {
                        field[fromPlace] = 0;
                    } else {
                        int continueFlying = fromPlace + toPlace + toPlace;
                        field[fromPlace] = 0;
                        if (field[fromPlace + toPlace] == 0) {
                            field[fromPlace + toPlace] = 1;
                        } else {
                            while (true) {
                                if (continueFlying > lengthOfFlight - 1) {
                                    break;
                                } else if (field[continueFlying] == 0) {
                                    field[continueFlying] = 1;
                                    break;
                                } else {
                                    continueFlying += toPlace;
                                }
                            }
                        }
                    }
                    break;
                case "left":
                    if (fromPlace - toPlace < 0) {
                        field[fromPlace] = 0;
                    } else {
                        field[fromPlace] = 0;
                        int continueFlying = fromPlace - toPlace - toPlace;
                        if (field[fromPlace - (toPlace)] == 0) {
                            field[fromPlace - (toPlace)] = 1;
                        } else
                            while (true) {
                            if (continueFlying < 0) {
                                break;
                            } else if (field[continueFlying] == 0) {
                                field[continueFlying] = 1;
                                break;
                            } else {
                                continueFlying -= toPlace;
                            }
                        }
                    }
                    break;
            }
            input = reader.readLine();
        }
        for (int aField : field) {
            System.out.print(aField + " ");
        }
    }
}

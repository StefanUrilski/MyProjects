package JavaOOP.WorkingWithAbstraction.Abstractions.JediGalaxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = parseToInt(reader.readLine());

        Galaxy galaxy = new Galaxy(dimensions[0], dimensions[1]);

        StarsManipulator manipulator = new StarsManipulator(galaxy);

        String input = reader.readLine();
        long collectedValues = 0;

        while (! input.equals("Let the Force be with you")) {
            int[] playerCoordinates = parseToInt(input);
            int[] evilCoordinates = parseToInt(reader.readLine());

            manipulator.destroy(evilCoordinates);
            collectedValues += manipulator.collect(playerCoordinates);

            input = reader.readLine();
        }

        System.out.println(collectedValues);

    }

    private static int[] parseToInt(String input) {
        return Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

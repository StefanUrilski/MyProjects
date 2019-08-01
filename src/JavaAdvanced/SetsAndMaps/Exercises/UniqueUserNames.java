package SetsAndMaps.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueUserNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> userNames = new LinkedHashSet<>();
        int rotations = Integer.valueOf(reader.readLine());

        while (rotations-- > 0) {
            String input = reader.readLine();
            userNames.add(input);
        }
        for (String user : userNames) {
            System.out.println(user);
        }

    }
}

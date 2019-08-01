package TechModule.DataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TownInfo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String town = reader.readLine();
        int population = Integer.valueOf(reader.readLine());
        int area = Integer.valueOf(reader.readLine());
        System.out.println(String.format("Town %s has population of %d and area %d " +
                "square km.", town, population, area));
    }
}

package OtherCourses.MapsLambdaAndStreamAPI.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> resources = new LinkedHashMap<>();

        String currResource = reader.readLine();

        while (!currResource.equals("stop")) {
            int quantity = Integer.valueOf(reader.readLine());
            resources.putIfAbsent(currResource, 0);
            resources.put(currResource, resources.get(currResource) + quantity);

            currResource = reader.readLine();
        }
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.println(entry.getKey() +  " -> " + entry.getValue());
        }


    }
}

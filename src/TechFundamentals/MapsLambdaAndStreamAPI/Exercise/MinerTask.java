package MapsLambdaAndStreamAPI.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class MinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> miner = new LinkedHashMap<>();
        String resource = reader.readLine();
        while (!resource.equals("stop")) {
            int quantity = Integer.valueOf(reader.readLine());
            if (!miner.containsKey(resource)) {
                miner.put(resource, 0);
            }
            miner.put(resource, miner.get(resource) + quantity);

            resource = reader.readLine();
        }
        for (Map.Entry<String, Integer> entry : miner.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            System.out.println(entry.getValue());
        }
    }
}

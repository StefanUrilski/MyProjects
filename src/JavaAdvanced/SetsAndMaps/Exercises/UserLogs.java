package SetsAndMaps.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();

        String input = reader.readLine();
        while (! input.equals("end")) {

            String name = input.substring(input.lastIndexOf("=") + 1);
            String ip = input.substring(input.indexOf("=") + 1, input.indexOf(" "));

            logs.putIfAbsent(name, new LinkedHashMap<>());

            if (!logs.get(name).containsKey(ip)) {
                logs.get(name).put(ip, 0);
            }
            //logs.get(name).putIfAbsent(ip, 1);

            logs.get(name).put(ip, logs.get(name).get(ip) + 1);

            input = reader.readLine();
        }

        for (String name : logs.keySet()) {
            System.out.println(name + ": ");
            int size = logs.get(name).size() - 1;
            for (Map.Entry<String, Integer> ip : logs.get(name).entrySet()) {
                if (size-- > 0) {
                    System.out.print(ip.getKey() + " => " + ip.getValue() + ", ");
                } else {
                    System.out.println(ip.getKey() + " => " + ip.getValue() + ".");
                }
            }
        }

    }
}

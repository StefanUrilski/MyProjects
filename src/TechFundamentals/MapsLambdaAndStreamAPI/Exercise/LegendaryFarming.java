package MapsLambdaAndStreamAPI.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> keyMats = new TreeMap<>();
        keyMats.put("shards", 0);
        keyMats.put("fragments", 0);
        keyMats.put("motes", 0);
        Map<String, Integer> junk = new TreeMap<>();
        boolean hasToBreak = false;
        while (!hasToBreak) {
            String[] farmed = reader.readLine().toLowerCase().split("\\s+");
            for (int i = 0; i < farmed.length; i += 2) {
                int quantity = Integer.valueOf(farmed[i]);
                String material = farmed[i + 1];
                if (keyMats.containsKey(material)) {
                    keyMats.put(material, keyMats.get(material) + quantity);
                    if (keyMats.get(material) >= 250) {
                        keyMats.put(material, keyMats.get(material) - 250);
                        hasToBreak = true;
                        switch (material) {
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            default:
                                System.out.println("Dragonwrath obtained!");
                                break;
                        }
                        break;
                    }
                } else {
                    if (!junk.containsKey(material)) {
                        junk.put(material, 0);
                    }
                    junk.put(material, junk.get(material) + quantity);
                }

            }
        }
        keyMats.entrySet().stream().sorted((e1, e2) -> {
            int value1 = e1.getValue();
            int value2 = e2.getValue();
            if (value2 == value1) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return Integer.compare(value2, value1);
            /* OtherCourses type of sort :)
            keyMats.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(pair -> System.out.println(pair.getKey() + ": "
                        + pair.getValue()));
             */
        }).forEach(pair -> System.out.println(pair.getKey() + ": "
                + pair.getValue()));
        junk.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}

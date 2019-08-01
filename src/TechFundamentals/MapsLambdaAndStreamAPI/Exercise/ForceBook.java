package MapsLambdaAndStreamAPI.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ForceBook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> forceBook = new LinkedHashMap<>();
        String input = reader.readLine();

        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                String[] registration = input.split(" \\| ");
                String side = registration[0];
                String user = registration[1];
                if (notInTheBook(forceBook, user)) {
                    if (!forceBook.containsKey(side)) {
                        forceBook.put(side, new ArrayList<>());
                    }
                    forceBook.get(side).add(user);
                }
            } else {
                String[] registration = input.split(" -> ");
                String side = registration[1];
                String user = registration[0];
                if (notInTheBook(forceBook, user)) {
                    forceBook.putIfAbsent(side, new ArrayList<>());
                    forceBook.get(side).add(user);
                    System.out.printf("%s joins the %s side!%n", user, side);
                } else {
                    removeUserFromSide(forceBook, user);
                    forceBook.putIfAbsent(side, new ArrayList<>());
                    forceBook.get(side).add(user);
                    System.out.printf("%s joins the %s side!%n", user, side);
                }
            }
            input = reader.readLine();
        }
        forceBook.entrySet().stream().sorted((e1, e2) -> {
            if (e2.getValue().size() == e1.getValue().size()) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return Integer.compare(e2.getValue().size(), e1.getValue().size());
        }).forEach(e -> {
            if (e.getValue().size() != 0) {
                System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                Collections.sort(e.getValue());
                //e.getValue().forEach();
                for (String value : e.getValue()) {
                    System.out.println("! " + value);
                }
            }

        });
    }

    private static void removeUserFromSide(Map<String, List<String>> forceBook, String user) {
        for (String key : forceBook.keySet()) {
            forceBook.get(key).remove(user);
        }
    }

    private static boolean notInTheBook(Map<String, List<String>> forceBook, String user) {
        for (String key : forceBook.keySet()) {
            if (forceBook.get(key).contains(user)) {
                return false;
            }
        }
        return true;
    }
}

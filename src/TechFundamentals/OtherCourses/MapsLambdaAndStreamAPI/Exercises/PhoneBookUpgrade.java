package TechFundamentals.OtherCourses.MapsLambdaAndStreamAPI.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneBookUpgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> contacts = new LinkedHashMap<>();
        String input = reader.readLine();

        while (!input.equals("END")) {
            String[] commands = input.split("\\s+");
            switch (commands[0]) {
                case "A":
                    String name = commands[1];
                    String phone = commands[2];
                    contacts.put(name, phone);
                    break;
                case "S":
                    String nameOfContact = commands[1];
                    if (contacts.containsKey(nameOfContact)) {
                        System.out.println(String.format("%s -> %s",
                                nameOfContact, contacts.get(nameOfContact)));
                    } else {
                        System.out.println("Contact " + nameOfContact + " does not exist.");
                    }
                    break;
                case "ListAll":
                    contacts.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e ->
                            System.out.println(e.getKey() + " -> " + e.getValue()));
                    break;
            }
            input = reader.readLine();
        }


    }
}

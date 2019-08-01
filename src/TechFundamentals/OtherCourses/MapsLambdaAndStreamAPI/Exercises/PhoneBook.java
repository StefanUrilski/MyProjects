package TechFundamentals.OtherCourses.MapsLambdaAndStreamAPI.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> contacts = new HashMap<>();
        String input = reader.readLine();

        while (!input.equals("END")) {
            String[] commands = input.split("\\s+");
            if (commands[0].equals("A")) {
                String name = commands[1];
                String phone = commands[2];
                contacts.put(name, phone);
            } else if (commands[0].equals("S")) {
                String name = commands[1];
                if (contacts.containsKey(name)) {
                    System.out.println(String.format("%s -> %s", name, contacts.get(name)));
                } else {
                    System.out.println("Contact " + name + " does not exist.");
                }
            }
            input = reader.readLine();
        }


    }
}

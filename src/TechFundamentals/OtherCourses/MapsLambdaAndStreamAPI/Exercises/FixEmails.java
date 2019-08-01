package OtherCourses.MapsLambdaAndStreamAPI.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> contacts = new LinkedHashMap<>();

        while (true) {
            String name = reader.readLine();
            if (name.equals("stop")) {
                break;
            }
            String email = reader.readLine();
            String[] temp = email.split("\\.");
            String emailExtension = temp[temp.length - 1];
            if (emailExtension.equals("us") || emailExtension.equals("uk") || emailExtension.equals("com")) {
            } else {
                contacts.put(name, email);
            }
        }
        for(Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

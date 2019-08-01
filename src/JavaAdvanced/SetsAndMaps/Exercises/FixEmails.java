package OtherCourses.SetsAndMaps.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> emailInfo = new LinkedHashMap<>();
        while (true) {
            String name = reader.readLine();
            if ("stop".equals(name)) {
                break;
            }
            String email = reader.readLine();
            emailInfo.put(name, email);
        }

        emailInfo.entrySet().stream().filter(e -> {
            int index = e.getValue().lastIndexOf(".");
            String curr = e.getValue().substring(index);
            return  ! ((curr.equalsIgnoreCase(".uk") || curr.equalsIgnoreCase(".us")
                    || curr.equalsIgnoreCase(".com")));
        }).forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

    }
}

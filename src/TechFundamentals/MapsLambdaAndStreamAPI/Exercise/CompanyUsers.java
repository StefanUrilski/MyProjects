package MapsLambdaAndStreamAPI.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> company = new TreeMap<>();
        String input = reader.readLine();

        while (!input.equals("End")) {
            String[] info = input.split(" -> ");
            String user = info[0];
            String id = info[1];
            if (!company.containsKey(user)) {
                company.put(user, new ArrayList<>());
            }
            if (!company.get(user).contains(id)) {
                company.get(user).add(id);
            }
            input = reader.readLine();
        }
        for (Map.Entry<String, List<String>> entry : company.entrySet()) {
            System.out.println(entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.println("-- " + entry.getValue().get(i));
            }
        }

    }
}

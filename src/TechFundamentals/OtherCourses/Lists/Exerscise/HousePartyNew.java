package TechFundamentals.OtherCourses.Lists.Exerscise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HousePartyNew {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<String> guests = new ArrayList<>();
        while (n-- > 0){
            String line = reader.readLine();

            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            if (!line.contains("not")) {
                if (guests.contains(name)){
                    System.out.println(name + " is already in the list!");
                } else {
                    guests.add(name);
                }
            } else {
                if (guests.contains(name)) {
                    guests.remove(name);
                } else {
                    System.out.println(name + " is not in the list!");
                }
            }
        }
        for (String guest : guests) {
            System.out.println(guest);
        }

    }
}

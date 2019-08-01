package OtherCourses.SetsAndMaps.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> patryMembers = new TreeSet<>();

        String input = "";

        while (! "PARTY".equals(input = reader.readLine())) {
            patryMembers.add(input);
        }
        while (! "END".equals(input = reader.readLine())) {
            patryMembers.remove(input);
        }

        System.out.println(patryMembers.size());
        for (String member : patryMembers) {
            System.out.println(member);
        }
    }
}

package OtherCourses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class demo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < 5; i++) {
            set.add(reader.readLine());
        }


    }
}
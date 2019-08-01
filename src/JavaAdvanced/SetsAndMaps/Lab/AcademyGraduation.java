package OtherCourses.SetsAndMaps.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Double>> book = new TreeMap<>();

        int a = Integer.valueOf(reader.readLine());

        while (a-- > 0) {
            String name = reader.readLine();
            double[] grades = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();
            book.putIfAbsent(name, new ArrayList<>());
            double average = 0;
            for (double grade : grades) {
                average += grade;
            }
            average /= grades.length;
            book.get(name).add(average);
        }
        for (Map.Entry<String, List<Double>> entry : book.entrySet()) {
            System.out.print(entry.getKey() + " is graduated with ");
            for (double value : entry.getValue()) {
                System.out.println(value);
            }
        }

    }
}

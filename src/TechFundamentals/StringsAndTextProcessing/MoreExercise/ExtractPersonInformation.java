package StringsAndTextProcessing.MoreExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractPersonInformation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(reader.readLine());

        while (a-- > 0) {
            String input = reader.readLine();
            int nameStartIndex = input.indexOf("@") + 1;
            int nameEndIndex = input.indexOf("|");
            int ageStartIndex = input.indexOf("#") + 1;
            int ageEndIndex = input.indexOf("*");
            String name = input.substring(nameStartIndex, nameEndIndex);
            String age = input.substring(ageStartIndex, ageEndIndex);
            System.out.println(String.format("%s is %s years old.", name, age));
        }

    }
}

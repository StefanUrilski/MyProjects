package TechFundamentals.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Train {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int wagonsCount = Integer.valueOf(reader.readLine());
        int[] people = new int[wagonsCount];
        int allPeople = 0;
        for (int i = 0; i < wagonsCount; i++) {
            people[i] = Integer.parseInt(reader.readLine());
            allPeople += people[i];
        }
        for (int wagon : people) {
            System.out.print(wagon + " ");
        }
        System.out.println();
        System.out.println(allPeople);

    }
}



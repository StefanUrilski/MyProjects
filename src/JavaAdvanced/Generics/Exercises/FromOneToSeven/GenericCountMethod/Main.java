package Generics.Exercises.FromOneToSeven.GenericCountMethod;

import Generics.Exercises.FromOneToSeven.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        List<Box> list = new ArrayList<>();

        while (n-- > 0) {
            String line = reader.readLine();
            Box box = null;
//            try {
//                box = new Box<>(Double.parseDouble(line));
//            } catch (Exception e) {
                box = new Box<>(line);
//            }
            list.add(box);
        }

        String valueToCompare = reader.readLine();

//        double valueToCompare = Double.valueOf(value);

        System.out.println(list.stream().filter(e -> e.compereTo(valueToCompare)).count());
    }
}

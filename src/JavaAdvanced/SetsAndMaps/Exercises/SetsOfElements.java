package SetsAndMaps.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndM = reader.readLine().split("\\s+");
        int n = Integer.valueOf(nAndM[0]);
        int m = Integer.valueOf(nAndM[1]);


        Set<Integer> setN = new LinkedHashSet<>(5);
        Set<Integer> setM = new HashSet<>();
        fillingTheSets(reader, n, m, setN, setM);

        for (Integer numb : setN) {
            if (setM.contains(numb)) {
                // setN.retainAll(setM); -> does the same without printing.
                System.out.print(numb + " ");
            }
        }

    }

    private static void fillingTheSets(BufferedReader reader, int n, int m, Set<Integer> setN, Set<Integer> setM) throws IOException {
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());
            setN.add(num);
        }
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(reader.readLine());
            setM.add(num);
        }
    }

}

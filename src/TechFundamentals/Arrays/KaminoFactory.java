package TechFundamentals.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KaminoFactory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sequenceLength = Integer.parseInt(reader.readLine());
        String input = reader.readLine();
        int countSequence = 1;
        List<String> dna = new ArrayList<>();
        List<Integer> holder = new ArrayList<>();
        while (!input.equals("Clone them!")) {
            dna = Arrays.stream(input.split("!"))
                    .collect(Collectors.toList());
            removeEmptyEntries(dna);
            holder.addAll(dna.stream().map(Integer::valueOf).collect(Collectors.toList()));


            input = reader.readLine();
            countSequence++;
        }

        System.out.println();
    }

    private static void removeEmptyEntries(List<String> dna) {
        for (int i = 0; i < dna.size(); i++) {
            if (dna.get(i).equals("")) {
                dna.remove(i);
                i--;
            }
        }
    }
}


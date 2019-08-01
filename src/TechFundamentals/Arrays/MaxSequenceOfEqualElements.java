package TechFundamentals.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> listNumbers = Arrays
                .stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxCount = 0;
        int maxNumValue = 0;
        int count = 1;

        List<Integer> counter = new ArrayList<>();
        for (int i = 1; i < listNumbers.size(); i++) {
            if (listNumbers.get(i - 1).equals(listNumbers.get(i))) {
                count++;
            } else {
                counter.add(count);
                counter.add(listNumbers.get(i - 1));
                count = 1;
            }
        }
        counter.add(count);
        counter.add(listNumbers.get(listNumbers.size() - 1));
        for (int i = 0; i < counter.size(); i += 2) {
            if (counter.get(i) > maxCount) {
                maxCount = counter.get(i);
                maxNumValue = counter.get(i + 1);
            }
        }
        for (int i = 0; i < maxCount; i++) {
            System.out.print(maxNumValue + " ");
        }

    }
}

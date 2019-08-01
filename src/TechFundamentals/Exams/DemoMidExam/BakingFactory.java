package TechFundamentals.Exams.DemoMidExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BakingFactory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int maxQuality = -1000;
        int maxAverage = -1000;
        int qualityLength = 1000;
        int[] bestBach = new int[5];
        while (!input.equals("Bake It!")) {
            int[] batch = Arrays.stream(input.split("#"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int currQuality = 0;
            for (int i : batch) {
                currQuality += i;
            }
            int currAverage = currQuality / batch.length;
            if (currQuality > maxQuality) {
                maxQuality = currQuality;
                maxAverage = currAverage;
                qualityLength = batch.length;
                bestBach = batch;
            } else if (currQuality == maxQuality) {
                if (currAverage > maxAverage) {
                    maxAverage = currAverage;
                    qualityLength = batch.length;
                    bestBach = batch;
                } else if (currAverage == maxAverage) {
                    if ((batch.length) < qualityLength){
                        qualityLength = batch.length;
                        bestBach = batch;
                    }
                }
            }
            input = reader.readLine();
        }
        System.out.println("Best Batch quality: " + maxQuality);
        for (int bach : bestBach) {
            System.out.print(bach + " ");
        }
    }

}

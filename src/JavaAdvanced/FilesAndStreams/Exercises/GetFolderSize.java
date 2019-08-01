package FilesAndStreams.Exercises;

import java.io.*;
import java.util.Arrays;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Stefan\\IdeaProjects\\MyProjects\\src" +
                "\\JavaAdvanced\\FilesAndStreams\\Java Stream\\Exercises\\";

        String firstFile = path + "\\Exercises Resources";
        String fileOut = path + "\\Out\\mergeTwoFiles.txt";

        File file = new File(firstFile);

        long sum = Arrays.stream(file.listFiles())
                .filter(e -> !e.isDirectory())
                .mapToLong(File::length)
                .sum();

        System.out.println("Folder getRows: " + sum);
    }
}

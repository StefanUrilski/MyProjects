package FilesAndStreams.Exercises;

import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Stefan\\IdeaProjects\\MyProjects\\src" +
                "\\JavaAdvanced\\FilesAndStreams\\Java Stream\\Exercises\\";

        String firstFile = path + "inputOne.txt";
        String secondFile = path + "inputTwo.txt";
        String fileOut = path + "\\Out\\mergeTwoFiles.txt";

        FileInputStream inputStream = new FileInputStream(firstFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = reader.readLine();

        FileWriter writer = new FileWriter(fileOut);
        readAndWrite(reader, line, writer);

        inputStream = new FileInputStream(secondFile);
        reader = new BufferedReader(new InputStreamReader(inputStream));

        line = reader.readLine();
        readAndWrite(reader, line, writer);

        writer.close();
    }

    private static void readAndWrite(BufferedReader reader, String line, FileWriter writer) throws IOException {
        while (line != null) {
            writer.write(line + System.lineSeparator());
            line = reader.readLine();
        }
    }
}

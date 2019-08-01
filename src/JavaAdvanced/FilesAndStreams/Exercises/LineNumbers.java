package FilesAndStreams.Exercises;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Stefan\\IdeaProjects\\MyProjects\\src" +
                "\\JavaAdvanced\\FilesAndStreams\\Java Stream\\Exercises\\";

        String fileIn = path + "inputLineNumbers.txt";
        String fileOut = path + "\\Out\\lineNumbers.txt";

        FileInputStream inputStream = new FileInputStream(fileIn);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        FileWriter outputStream = new FileWriter(fileOut);

        String line = reader.readLine();
        int count = 0;
        while (line != null) {
            count++;

            outputStream.write(count + ". " + line + System.lineSeparator());

            line = reader.readLine();
        }

        outputStream.close();

    }
}

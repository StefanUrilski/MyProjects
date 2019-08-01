package FilesAndStreams.Exercises;

import java.io.*;

public class SumLines {
    public static void main(String[] args) throws IOException {
        BufferedReader reader;

        String path = "C:\\Users\\Stefan\\IdeaProjects\\MyProjects\\src" +
                "\\JavaAdvanced\\FilesAndStreams\\Java Stream\\Exercises\\";

        String fileIn = path + "input.txt";
        String fileOut = path + "\\Out\\sumBits.txt";

        FileInputStream inputStream = new FileInputStream(fileIn);

        FileWriter outputStream = new FileWriter(fileOut);

        reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = reader.readLine();
        String newLine = System.getProperty("line.separator");
        int sum = 0;
        while (line != null) {

            //sum = 0;

            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }


            line = reader.readLine();
        }
        outputStream.write(sum + newLine);

        outputStream.close();
    }
}

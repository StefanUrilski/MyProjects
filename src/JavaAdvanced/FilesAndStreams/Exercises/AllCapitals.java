package FilesAndStreams.Exercises;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Stefan\\IdeaProjects\\MyProjects\\src" +
                "\\JavaAdvanced\\FilesAndStreams\\Java Stream\\Exercises\\";

        String fileIn = path + "input.txt";
        String fileOut = path + "\\Out\\allCaps.txt";

        FileInputStream inputStream = new FileInputStream(fileIn);

        FileWriter outputStream = new FileWriter(fileOut);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = reader.readLine();

        while (line != null) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < line.length(); i++) {
                if (Character.isLowerCase(line.charAt(i))) {
                    char curr = (char) (line.charAt(i) - 32);
                    builder.append(curr);
                } else {
                    builder.append(line.charAt(i));
                }
            }

            outputStream.write(builder.toString() + System.lineSeparator());

            line = reader.readLine();
        }

        outputStream.close();
    }
}

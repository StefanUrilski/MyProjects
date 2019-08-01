package FilesAndStreams.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StreamBasics {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Stefan\\IdeaProjects\\MyProjects" +
                "\\src\\JavaAdvanced\\FilesAndStreams\\Java Stream\\Lab\\";
        String readFile = path + "input.txt";

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(readFile);
            int data = inputStream.read();
            while (data >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(data));
                data = inputStream.read();
            }
        } catch (FileNotFoundException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }


    }
}

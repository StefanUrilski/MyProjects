package TechFundamentals.StringsAndTextProcessing.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractFile {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathToFile = reader.readLine();
        int startFileIndex = pathToFile.lastIndexOf("\\") + 1;
        int startExtensionIndex = pathToFile.lastIndexOf(".") + 1;
        String fileName = pathToFile.substring(startFileIndex, startExtensionIndex - 1);
        String fileExtension = pathToFile.substring(startExtensionIndex);
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);

    }
}

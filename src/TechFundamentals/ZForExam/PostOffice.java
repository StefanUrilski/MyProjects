package ZForExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\|");
        String firstPart = input[0];
        String secondPart = input[1];
        String thirdPart = input[2];

        // First part -> finding the capital letters
        String letters = "";
        for (int i = 0; i < firstPart.length(); i++) {
            if (Character.isUpperCase(firstPart.charAt(i)) && i != 0) {
                char symbol = firstPart.charAt(i - 1);
                if (symbol == '#' || symbol == '$' || symbol == '%' || symbol == '*' || symbol == '&') {
                    String curr = firstPart.substring(i);
                    int count = 0;
                    while (Character.isUpperCase(curr.charAt(count))) {
                        count++;
                    }
                    if (symbol == curr.charAt(count)) {
                        letters = curr.substring(0, count);
                        break;
                    }
                }
            }
        }

        // Second part -> find the word's first capital letter and the rest of the length of the word.
        int startPoint = secondPart.indexOf(":");
        while (secondPart.contains(":")) {
            if (startPoint < 1) {
                secondPart = secondPart.substring(startPoint + 1);
                startPoint = secondPart.indexOf(":");
            }
            String curr = secondPart.substring(startPoint - 2, startPoint + 3);
            Pattern pattern = Pattern.compile("[1-9]{2}:[0-9]{2}");
            Matcher matcher = pattern.matcher(curr);
            if (matcher.matches()) {
                int charCode = Integer.parseInt(curr.substring(0, 2));
                char capitalLetter = (char) charCode ;
                for (int i = 0; i < letters.length(); i++) {
                    System.out.println();
                    // TODO ...
                }
            }
//
//            String curr = secondPart.substring(startPoint - 2, startPoint + 3);
//            int index = curr.charAt(0);
//            if (Character.isDigit(curr.charAt(0)) && Character.isDigit(curr.charAt(1))
//                    && Character.isDigit(curr.charAt(3)) && Character.isDigit(curr.charAt(4))){
//                int charCode = Integer.parseInt(curr.substring(0, 2));
//                char capitalLetter = (char) charCode ;
//                String find
//                if (letters.(capitalLetter))
//            }



        }



    }
}

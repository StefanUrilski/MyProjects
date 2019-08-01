package TechFundamentals.OtherCourses.Lists.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SplitByWord {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] inputWords = input.split("[\\s+,;:.!/]");

        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> lower = new ArrayList<>();
        ArrayList<String> upper = new ArrayList<>();
        ArrayList<String> mixed = new ArrayList<>();
        for (String inputWord : inputWords) {
            if (inputWord.equals("")){
                continue;
            }
            words.add(inputWord);
        }
        for (int i = 0; i < words.size(); i++) {
            String curr = words.get(i);
            if (isLower(curr)) {
                lower.add(curr);
            } else if (isUpper(curr)){
                upper.add(curr);
            }else {
                mixed.add(curr);
            }
        }
        System.out.print("Lower-case: ");
        System.out.println(String.join(", ", lower));
        System.out.print("Mixed-case: ");
        System.out.println(String.join(", ", mixed));
        System.out.print("Upper-case: ");
        System.out.println(String.join(", ", upper));


    }
    static boolean isLower (String word){
        for (int i = 0; i < word.length(); i++) {
            char symbol = word.charAt(i);
            if (symbol < 'a' || symbol > 'z') {
                return false;
            }
        }
        return true;
    }
    static boolean isUpper (String word){
        for (int i = 0; i < word.length(); i++) {
            char symbol = word.charAt(i);
            if (symbol < 'A' || symbol > 'Z') {
                return false;
            }
        }
        return true;
    }
}

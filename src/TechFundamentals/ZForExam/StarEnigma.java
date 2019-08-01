package ZForExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.valueOf(reader.readLine());
        Map<String, List<String>> messageInfo = new LinkedHashMap<>();
        messageInfo.put("Attacked", new ArrayList<>());
        messageInfo.put("Destroyed", new ArrayList<>());
        while (lines-- > 0) {
            String inputCoded = reader.readLine();
            String input = reductionChars(inputCoded);
            Pattern pattern = Pattern.compile("[^@\\-!:>]*?@([A-z]+)[^@\\-!:>]*?:(\\d+)[^@\\-!:>]*?!(A|D)![^@\\-!:>]*?->(\\d+\\.\\d+|\\d+)[^@\\-!:>]*?");
            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) {
                String type = matcher.group(3);
                if (type.equals("A")) {
                    type = "Attacked";
                } else {
                    type = "Destroyed";
                }
                String name = matcher.group(1);
                messageInfo.get(type).add(name);
            }

        }
        for (Map.Entry<String, List<String>> entry : messageInfo.entrySet()) {
            System.out.println(entry.getKey() + " planets: " + entry.getValue().size());
            Collections.sort(entry.getValue());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.println("-> " + entry.getValue().get(i));
            }
        }

    }

    private static String reductionChars(String input) {
        String inputToLower = input.toLowerCase();
        int result = 0;
        for (int i = 0; i < inputToLower.length(); i++) {
            if (inputToLower.charAt(i) == 's' || inputToLower.charAt(i) == 't' || inputToLower.charAt(i) == 'a'
                    || inputToLower.charAt(i) == 'r') {
                result++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char curr = (char) (input.charAt(i) - result);
            builder.append(curr);
        }
        return builder.toString();
    }
}

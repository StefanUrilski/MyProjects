package TechFundamentals.Lists.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> code = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String inputCommands = reader.readLine();

        while (!inputCommands.equals("3:1")) {
            String[] commands = inputCommands.split("\\s+");
            int startIndex = Integer.parseInt(commands[1]);
            int endIndex = Integer.parseInt(commands[2]);
            switch (commands[0]) {
                case "merge":
                    String merge = "";
                    int count = 0;
                    for (int i = startIndex; i <= endIndex; i++) {
                        if (startIndex < 0) {
                            startIndex = 0;
                            i = -1;
                            continue;
                        }
                        if (i >= code.size()) {
                            break;
                        }

                        merge += code.get(i);
                        count++;
                    }
                    for (int i = 0; i < count; i++) {
                        code.remove(startIndex);
                    }
                    if (endIndex >= 0 && count != 0) {
                        code.add(startIndex, merge);
                    }
                    break;
                case "divide":
                    String divide = code.get(startIndex);
                    code.remove(startIndex);
                    int length = divide.length();
                    int index = 0;
                    for (int i = 0; i < endIndex; i++) {
                        String pieces = "";
                        int pieceSize = length / endIndex;
                        if (i != endIndex - 1) {
                            while (pieceSize-- > 0) {
                                pieces += divide.charAt(index);
                                index++;
                            }
                        } else {
                            while (index != length) {
                                pieces += divide.charAt(index);
                                index++;
                            }
                        }
                        code.add(startIndex + i, pieces);
                    }
                    break;
            }

            inputCommands = reader.readLine();
        }
        for (String s : code) {
            System.out.print(s + " ");
        }

    }
}

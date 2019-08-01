package TechFundamentals.Exams.MidExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuestsJournal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        List<String> adventurePath = Arrays.stream(path.split(", ")).collect(Collectors.toList());
        String input = reader.readLine();

        while (!input.equals("Retire!")) {
            String[] commands = input.split(" - ");
            String quest = commands[1];
            switch (commands[0]) {
                case "Start":
                    if (!path.contains(quest)) {
                        adventurePath.add(quest);
                    }
                    break;
                case "Complete":
                    adventurePath.remove(quest);
                    break;
                case "Side Quest":
                    String[] sideQuest = quest.split(":");
                    if (adventurePath.contains(sideQuest[0])) {
                        if (!adventurePath.contains(sideQuest[1])) {
                            int index = adventurePath.indexOf(sideQuest[0]) + 1;
                            adventurePath.add(index, sideQuest[1]);
                        }
                    }
                    break;
                case "Renew":
                    if (adventurePath.contains(quest)) {
                        adventurePath.remove(quest);
                        adventurePath.add(quest);
                    }
                    break;
                    default:
                        System.out.println("Wrong input! Try again.");
                        break;
            }
            input = reader.readLine();
        }
        System.out.println(String.join(", ", adventurePath));

    }
}

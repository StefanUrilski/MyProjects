package TechFundamentals.Lists.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> schedule = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());

        String input = reader.readLine();
        while (!input.equals("course start")) {
            String[] commands = input.split(":");
            String title = commands[1];
            switch (commands[0]) {
                case "Add":
                    if (!schedule.contains(title)) {
                        schedule.add(title);
                    }
                    break;
                case "Insert":
                    int index = Integer.valueOf(commands[2]);
                    if (!schedule.contains(title)) {
                        schedule.add(index, title);
                    }
                    break;
                case "Remove":
                    schedule.remove(title);
                    break;
                case "Swap":
                    String titleToSwap = commands[2];
                    String exerciseToTitleFirst = title + "-Exercise";
                    String exerciseToTitleSecond = titleToSwap + "-Exercise";
                    int indexOfTitle = schedule.indexOf(title);
                    int indexOfTitleToSwap = schedule.indexOf(titleToSwap);
                    if (schedule.contains(title) && schedule.contains(titleToSwap)) {
                        if (schedule.contains(exerciseToTitleFirst) || schedule.contains(exerciseToTitleSecond)) {
                            schedule.remove(indexOfTitle);
                            schedule.add(indexOfTitle, titleToSwap);
                            schedule.remove(indexOfTitleToSwap);
                            schedule.add(indexOfTitleToSwap, title);
                            if (schedule.contains(exerciseToTitleFirst)) {
                                schedule.remove(exerciseToTitleFirst);
                                schedule.add(indexOfTitleToSwap + 1, exerciseToTitleFirst);
                            } else {
                                schedule.remove(exerciseToTitleSecond);
                                schedule.add(indexOfTitle + 1, exerciseToTitleSecond);
                            }
                        } else {
                            schedule.remove(indexOfTitleToSwap);
                            schedule.add(indexOfTitleToSwap, title);
                            schedule.remove(indexOfTitle);
                            schedule.add(indexOfTitle, titleToSwap);
                        }
                    }

                    break;
                case "Exercise":
                    String exercise = title + "-Exercise";
                    if (!schedule.contains(exercise)) {
                        if (!schedule.contains(title)) {
                            schedule.add(title);
                        }
                        int titleIndex = schedule.indexOf(title) + 1;
                        schedule.add(titleIndex, exercise);
                    }
                    break;
            }
            input = reader.readLine();
        }
        for (int i = 0; i < schedule.size(); i++) {
            System.out.println(i + 1 + "." + schedule.get(i));
        }

    }
}

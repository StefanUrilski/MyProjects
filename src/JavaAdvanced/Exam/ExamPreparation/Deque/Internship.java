package Exam.ExamPreparation.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Internship {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfTasks = Integer.valueOf(reader.readLine());
        int countOfPeople = Integer.valueOf(reader.readLine());

        ArrayDeque<String> problems = new ArrayDeque<>();
        ArrayDeque<String> people = new ArrayDeque<>();

        for (int i = 0; i < countOfTasks; i++) {
            problems.push(reader.readLine());
        }

        Pattern pattern = Pattern.compile("[A-Z][a-z]+ [A-Z][a-z]+");
        for (int i = 0; i < countOfPeople; i++) {
            String input = reader.readLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                people.offer(input);
            }
        }

        while (people.size() != 1) {
            if (problems.isEmpty()) {
                break;
            }
            String currTask = problems.poll();
            String currPerson = people.poll();
            int sumOfTask = sumOfTheChars(currTask);
            assert currPerson != null;
            int sumOfName = sumOfTheChars(currPerson);

            if (sumOfTask < sumOfName) {
                people.offer(currPerson);
                System.out.printf("%s solved %s.%n", currPerson, currTask);
            } else {
                System.out.printf("%s failed %s.%n", currPerson, currTask);
                problems.offer(currTask);
            }
        }

        if (problems.isEmpty()) {
            System.out.println(String.join(", ", people));
        } else {
            System.out.println(people.poll() + " gets the job!");
        }

    }

    private static int sumOfTheChars(String words) {
        int result = 0;
        for (int i = 0; i < words.length(); i++) {
            result += words.charAt(i);
        }
        return result;
    }
}

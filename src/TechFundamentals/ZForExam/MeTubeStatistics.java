package ZForExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class MeTubeStatistics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> video = new LinkedHashMap<>();
        Map<String, Integer> likes = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!input.equals("stats time")) {
            if (input.contains("-")) {
                String[] tokens = input.split("-");
                String title = tokens[0];
                int views = Integer.valueOf(tokens[1]);
                likes.putIfAbsent(title, 0);
                if (!video.containsKey(title)) {
                    video.put(title, views);
                } else {
                    video.put(title, video.get(title) + views);
                }
            } else if (input.contains(":")) {
                String[] tokens = input.split(":");
                String title = tokens[1];
                if (tokens[0].equals("like")) {
                    if (video.containsKey(title)) {
                        likes.put(title, likes.get(title) + 1);
                    }
                } else if (tokens[0].equals("dislike")) {
                    if (video.containsKey(title)) {
                        likes.put(title, likes.get(title) - 1);
                    }
                }
            }
            input = reader.readLine();
        }
        input = reader.readLine();
        if (input.equals("by views")) {
            video.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(e -> System.out.printf("%s - %d views - %d likes%n",
                            e.getKey(), e.getValue(), likes.get(e.getKey())));
        } else if (input.equals("by likes")) {
            likes.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(e -> System.out.printf("%s - %d views - %d likes%n",
                    e.getKey(), video.get(e.getKey()), e.getValue()));
        }
    }
}

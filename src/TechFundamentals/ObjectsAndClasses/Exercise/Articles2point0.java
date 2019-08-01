package TechFundamentals.ObjectsAndClasses.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Articles2point0 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        List<Article> articlesList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(", ");
            Article article = new Article();
            article.setTitle(tokens[0]);
            article.setContent(tokens[1]);
            article.setAuthor(tokens[2]);
            articlesList.add(article);
        }
        String type = reader.readLine();
        articlesList.stream().sorted((a1, a2) -> {
            switch (type) {
                case "title":
                    return a1.getTitle().compareTo(a2.getTitle());
                case "content":
                    return a1.getContent().compareTo(a2.getContent());
                default:
                    return a1.getAuthor().compareTo(a2.getAuthor());
            }
        }).forEach(System.out::println);

    }


}

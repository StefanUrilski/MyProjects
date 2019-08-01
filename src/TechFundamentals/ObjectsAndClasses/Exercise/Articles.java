package TechFundamentals.ObjectsAndClasses.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Articles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(", ");
        Article article = new Article();
        /*
        for (String anInput : input) {
            if (anInput.contains("title")) {
                article.setTitle(anInput);
            } else if (anInput.contains("content")) {
                article.setContent(anInput);
            } else if (anInput.contains("author")) {
                article.setAuthor(anInput);
            }
        }
        */
        article.setTitle(input[0]);
        article.setContent(input[1]);
        article.setAuthor(input[2]);
        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(": ");
            switch (tokens[0]) {
                case "Edit":
                    article.setContent(tokens[1]);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(tokens[1]);
                    break;
                case "Rename":
                    article.setTitle(tokens[1]);
                    break;
            }
        }
        System.out.println(article);
    }
}
class Article {
    private String title;
    private String content;
    private String author;

    public Article() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return this.title + " - " + this.content + ": " + this.author;
    }

}

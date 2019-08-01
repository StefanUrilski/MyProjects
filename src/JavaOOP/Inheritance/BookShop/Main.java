package JavaOOP.Inheritance.BookShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String author = reader.readLine();
        String title = reader.readLine();
        double price = Double.parseDouble(reader.readLine());

        try {
            Book book = new Book(author, title, price);
            GoldenEditionBook goldenEdition = new GoldenEditionBook(author, title, price);

            System.out.println(book.toString());
            System.out.println(goldenEdition.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}

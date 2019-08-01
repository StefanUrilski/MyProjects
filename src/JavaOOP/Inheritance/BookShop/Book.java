package JavaOOP.Inheritance.BookShop;

public class Book {
    private String author;
    private String title;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    protected String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        if (! authorNameIsCorrect(author)) {
            throw new IllegalArgumentException("Author not valid!");
        }

        this.author = author;
    }

    protected String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }

        this.title = title;
    }

    protected double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price < 1) {
            throw new IllegalArgumentException("Price not valid!");
        }

        this.price = price;
    }

    private boolean authorNameIsCorrect(String name) {
        if (name.length() < 3) {
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append("Title: ").append(this.getTitle()).append(System.lineSeparator());
        sb.append("Author: ").append(this.getAuthor()).append(System.lineSeparator());
        sb.append("Price: ").append(this.getPrice()).append(System.lineSeparator());

        return sb.toString();
    }
}

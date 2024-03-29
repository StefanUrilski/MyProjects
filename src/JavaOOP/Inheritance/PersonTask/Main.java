package JavaOOP.Inheritance.PersonTask;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        try {
            Child child = new Child(name, age);
            System.out.println(child);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}

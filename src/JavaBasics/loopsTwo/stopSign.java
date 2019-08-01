import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class stopSign {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        StringBuilder builder = new StringBuilder();
        // print top
        builder.append(repeatStr(".", n + 1));
        builder.append(repeatStr("_", n * 2 + 1));
        builder.append(repeatStr(".", n + 1));
        builder.append("\n");
        for (int i = 0; i < n; i++) {
            builder.append(repeatStr(".", n - i));
            builder.append("//");
            builder.append(repeatStr("_", n * 2 - 1 + (i * 2)));
            builder.append("\\\\");
            builder.append(repeatStr(".", n - i));
            builder.append("\n");
        }
        // print Stop
        builder.append("//");
        builder.append(repeatStr("_", n * 2 - 3));
        builder.append("STOP!");
        builder.append(repeatStr("_", n * 2 - 3));
        builder.append("\\\\");
        builder.append("\n");
        // print bottom
        for (int i = 0; i < n; i++) {
            builder.append(repeatStr(".", i));
            builder.append("\\\\");
            builder.append(repeatStr("_", n * 4 - 1 - (i * 2) ));
            builder.append("//");
            builder.append(repeatStr(".", i));
            builder.append("\n");
        }
        System.out.println(builder);
    }
   private static String repeatStr(String simbol, int lenght){
        String result = "";
        for (int i = 0; i < lenght; i++) {
            result += simbol;
        }
        return result;
    }
}

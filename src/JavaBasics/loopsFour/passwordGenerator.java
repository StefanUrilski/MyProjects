package loopsThree.forExam;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class passwordGenerator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int l = Integer.valueOf(reader.readLine());
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (char k ='a'; k < 'a' + l; k++) {
                    for (char m = 'a'; m < 'a' + l; m++) {
                        for (int o = 0; o <= n; o++) {
                            if (o > i && o > j) {
                                System.out.print("" + i + j + k + m + o + " ");
                            }
                        }
                    }
                }

            }

        }
    }
}

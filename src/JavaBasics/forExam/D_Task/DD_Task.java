package forExam.D_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DD_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(reader.readLine());
        double finances = Double.valueOf(reader.readLine()) / a;
        int jelev = 0;
        int royal = 0;
        int roli = 0;
        int trofon = 0;
        int sino = 0;
        int others = 0;
        for (int i = 0; i < a; i++) {
            String lecturers = reader.readLine();
            switch (lecturers) {
                case "Jelev":
                    jelev ++;
                    break;
                case "RoYaL":
                    royal ++;
                    break;
                case "Roli":
                    roli ++;
                    break;
                case "Trofon":
                    trofon ++;
                    break;
                case "Sino":
                    sino ++;
                    break;
                    default:
                        others ++;
                        break;
            }
        }
        System.out.printf("Jelev salary: %.2f lv\n", jelev * finances);
        System.out.printf("RoYaL salary: %.2f lv\n", royal * finances);
        System.out.printf("Roli salary: %.2f lv\n", roli * finances);
        System.out.printf("Trofon salary: %.2f lv\n", trofon * finances);
        System.out.printf("Sino salary: %.2f lv\n", sino * finances);
        System.out.printf("Others salary: %.2f lv\n", others * finances);
    }
}

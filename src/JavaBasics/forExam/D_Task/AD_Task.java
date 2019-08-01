package forExam.D_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AD_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double x = Double.valueOf(reader.readLine());
        double y = Double.valueOf(reader.readLine());
        double h = Double.valueOf(reader.readLine());
        // Walls
        double sideWalls = x * y;
        double window = 1.5 * 1.5;
        double bothWalls = 2 * sideWalls - 2 *  window;
        double backWall = x * x;
        double entrance  = 1.2 * 2;
        double frontAndBackWalls = backWall * 2 - entrance;
        double allWalls = bothWalls + frontAndBackWalls;
        double greenPaint = allWalls / 3.4;
        // Roof
        double oneSide = 2 * (x * y);
        double secondSide = 2 * (x * h / 2);
        double allRoof = oneSide + secondSide;
        double redPaint = allRoof / 4.3;

        System.out.printf("%.2f\n", greenPaint);
        System.out.printf("%.2f", redPaint);

    }
}

package forExam.E_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BE_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double money = Double.valueOf(reader.readLine());
        double width = Double.valueOf(reader.readLine());
        double length = Double.valueOf(reader.readLine());
        double triangleSide = Double.valueOf(reader.readLine());
        double heightTile = Double.valueOf(reader.readLine());
        double tilePrice = Double.valueOf(reader.readLine());
        double workPrice = Double.valueOf(reader.readLine());

        double areaFloor = width * length;
        double areaTitle = (triangleSide * heightTile) / 2;
        double tileNeeded = areaFloor / areaTitle + 5;
        tileNeeded = Math.ceil(tileNeeded);
        double sum = tileNeeded * tilePrice + workPrice;
        double diff = money - sum;

        if (diff >= 0) {
            System.out.printf("%.2f lv left.", diff);
        } else {
            System.out.printf("You'll need %.2f lv more.", Math.abs(diff));
        }

    }
}

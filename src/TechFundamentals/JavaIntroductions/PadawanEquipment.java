package TechModule.JavaIntroductions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadawanEquipment {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double amountOfMoney = Double.valueOf(reader.readLine());
        int studentsCount = Integer.valueOf(reader.readLine());
        double lightsaberPrice = Double.valueOf(reader.readLine());
        double robesPrice = Double.valueOf(reader.readLine());
        double beltsPrice = Double.valueOf(reader.readLine());

        double lightsaberDiscount = Math.ceil(studentsCount * 0.1);
        int freeBelts = studentsCount / 6;
        double allOrderPrice = lightsaberPrice * (studentsCount + lightsaberDiscount) +
                robesPrice * (studentsCount) + beltsPrice * (studentsCount - freeBelts);
        if (amountOfMoney >= allOrderPrice) {
            System.out.println(String.format("The money is enough - it would cost %.2flv.",allOrderPrice));
        } else {
            System.out.println(String.format("Ivan Cho will need %.2flv more.", allOrderPrice - amountOfMoney));
        }
    }
}

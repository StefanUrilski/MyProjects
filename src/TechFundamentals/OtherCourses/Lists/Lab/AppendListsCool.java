package TechFundamentals.OtherCourses.Lists.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class AppendListsCool {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[]arr = reader.readLine().split("\\|");
        ArrayList<String> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            String split = arr[i];
            String[] splitArray = split.split(" ");
            Collections.addAll(list, splitArray);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("")){
                list.remove(i);
                i--;
            }
        }
        for (String items : list) {
            System.out.print(items + " ");
        }

    }
}

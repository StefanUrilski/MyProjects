package TechFundamentals.OtherCourses.Lists.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AppendLists {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[]arr = reader.readLine().split("\\|");
        ArrayList<String> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            String split = arr[i];
            String[] splitArray = split.split(" ");
            for (int j = 0; j < splitArray.length; j++) {
                if (splitArray[j].equals("")){
                    continue;
                }
                list.add(splitArray[j]);
            }
        }

        for (String items : list) {
            System.out.print(items + " ");
        }

    }
}

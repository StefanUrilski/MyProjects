package TechFundamentals.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.valueOf(reader.readLine());

        List<String> triangle = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        String row = "";
        String temp = "";
        for (int i = 0; i < rows; i++) {
            if (i < 2) {
                for (int j = 0; j <= i; j++) {
                    row += "1 ";
                }
                triangle.add(row);
                temp = triangle.get(i);
                row = "";
            } else {
                tempList = Arrays.stream(temp.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                for (int j = 0; j <= i; j++) {
                    String numbersInRow = "";
                    int inter = 0;
                    if (j == 0 || j == i) {
                        numbersInRow = "1 ";
                    } else {
                        inter = tempList.get(j) + tempList.get(j - 1);
                        numbersInRow = inter + " ";
                    }
                    row += numbersInRow;
                }
                triangle.add(row);
                temp = row;
                row = "";
            }
        }
        for (String s : triangle) {
            System.out.println(s);
        }
    }
}
//        int length = Integer.valueOf(reader.readLine());
//        int sum = 0;
//        int[] sumHolder = new int[length];
//        for (int i = 0; i < length; i++) {
//            String inputName = reader.readLine();
//            sumCharacter(inputName, sum);
//            sumHolder[i] = sum;
//        }
//        bubbleSort(sumHolder);
//
//        for (int i : sumHolder) {
//            System.out.println(i);
//        }
//
//    }
//
//    private static void bubbleSort(int ar[]) {
//        for (int i = (ar.length - 1); i >= 0; i--) {
//            for (int j = 1; j <= i;j++) {
//                if (ar[j - 1] > ar[j]) {
//                    int temp = ar[j - 1];
//                    ar[j - 1] = ar[j];
//                    ar[j] = temp;
//                }
//            }
//        }
//    }
//
//    private static int sumCharacter(String inputName, int sum) {
//        for (int i = 0; i < inputName.length(); i++) {
//            char temp = inputName.charAt(i);
//            int multilplied = (int) temp;
//            sum += temp;
//        }
//        sum *= inputName.length();
//        return sum;
//    }
//}

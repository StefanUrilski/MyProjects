package Exam.DemoExam.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExcelFunctions {
    private static List<List<String>> matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        matrix = new ArrayList<>();

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(", ");

            matrix.add(new ArrayList<>());
            for (String token : tokens) {
                matrix.get(i).add(token);
            }
        }

        String[] parts = reader.readLine().split("\\s+");

        String command = parts[0];
        String header = parts[1];
        if (command.equals("hide")) {
            int col = findTheCol(header);

            for (List<String> matrix1 : matrix) {
                matrix1.remove(col);
            }

        } else if (command.equals("sort")) {
            sortTheMatrix(header);

        } else {
            String secondHeader = parts[2];
            List<String> row = matrix.get(findTheRow(header));
            List<String> row2 = matrix.get(findTheRow(secondHeader));

            matrix.clear();
            matrix.add(new ArrayList<>());
            matrix.add(new ArrayList<>());
            matrix.get(0).addAll(row);
            matrix.get(1).addAll(row2);

//            matrix = matrix.stream()
//                    .filter(r -> r.contains(header) || r.contains(secondHeader))
//                    .destroy(Collectors.toList());
        }
        for (List<String> rows : matrix) {
            System.out.println(String.join(" | ", rows));
        }
    }

    private static void sortTheMatrix(String header) {
        int row = findTheRow(header);
        int col = findTheCol(header);

        List<String> temp = matrix.get(row);
        matrix.remove(row);

        for (int i = 0; i < matrix.size() - 1; i++) {
            for (int j = 1; j < matrix.size(); j++) {
                if (matrix.get(i).get(col).compareTo(matrix.get(j).get(col)) > 0) {
                    List<String> tmp = matrix.get(i);
                    matrix.set(i, matrix.get(j));
                    matrix.set(j, tmp);
                }
            }
        }

        matrix.add(row, temp);
    }

    private static int findTheCol(String header) {

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                if (matrix.get(i).get(j).equals(header)) {
                    return j;
                }
            }
        }
        return 0;
    }

    private static int findTheRow(String header) {

        for (int i = 0; i < matrix.size(); i++) {
            if (matrix.get(i).contains(header)) {
                return i;
            }
        }
        return 0;
    }
}

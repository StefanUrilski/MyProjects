package TechFundamentals.Lists.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        List<String> partyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            partyList.add(reader.readLine());
        }
        List<String> names = new ArrayList<>();
        getNamesAndResponse(partyList, names);

        for (int i = 0; i < names.size(); i += 2) {
            for (int j = 0; j < names.size(); j += 2) {
                if (j == i) {
                } else if (names.get(i).equals(names.get(j))) {
                    if (names.get(i + 1).equals("going") && names.get(j + 1).equals("going")) {
                        System.out.println(names.get(i) + " is already in the list!");
                        names.remove(j);
                        names.remove(j);
                        j -= 2;
                    } else {
                        names.remove(i);
                        names.remove(i);
                        names.remove(j - 1);
                        names.remove(j - 2);
                        j -= 4;
                    }
                }
            }
        }
        for (int i = 1; i < names.size(); i += 2) {
            if (names.get(i).equals("not")) {
                System.out.println(names.get(i - 1) + " is not in the list!");
                names.remove(i);
                names.remove(i - 1);
            }
        }
        for (int i = 0; i < names.size(); i += 2) {
            System.out.println(names.get(i));
        }


    }

    private static void getNamesAndResponse(List<String> partyList, List<String> names) {
        for (String curr : partyList) {
            List<String> temp = Arrays.stream(curr.split("\\W+"))
                    .collect(Collectors.toList());
            names.add(temp.get(0));

            for (String aTemp : temp) {
                if (aTemp.equals("not")) {
                    names.add(aTemp);
                    break;
                } else if (aTemp.equals("going")) {
                    names.add(aTemp);
                }
            }
        }
    }
}

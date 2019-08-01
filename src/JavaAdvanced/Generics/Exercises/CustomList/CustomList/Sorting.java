package Generics.Exercises.CustomList.CustomList;

public class Sorting {

    public static <T extends Comparable<T>> void sort(SmartArray<T> smartArray) {
        for (int i = 0; i < smartArray.size(); i++) {
            for (int j = i + 1; j < smartArray.size(); j++) {
                if (smartArray.get(i).compareTo(smartArray.get(j)) > 0) {
                    smartArray.swap(i, j);
                }
            }
        }
    }
}

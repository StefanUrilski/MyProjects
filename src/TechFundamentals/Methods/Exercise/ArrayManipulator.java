package TechFundamentals.Methods.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayManipulator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean stop = true;

        while (stop) {
            String command = reader.readLine();
            String[] commands = command.split(" ");
            switch (commands[0]) {
                case "exchange":
                    exchangeByGivenIndex(numbers, Integer.valueOf(commands[1]));
                    break;
                case "max":
                    String maxType = commands[1];
                    String maxValueAndIndex = maxValue(numbers,maxType);
                    String[] tempMax = maxValueAndIndex.split(" ");
                    int max = Integer.parseInt(tempMax[0]);
                    int indexMax = Integer.parseInt(tempMax[1]);
                    printOddAndEven(maxType, max, indexMax);
                    break;
                case "min":
                    String minType = commands[1];
                    String minValueAndIndex = minValue(numbers, minType);
                    String[] tempMin = minValueAndIndex.split(" ");
                    int min = Integer.parseInt(tempMin[0]);
                    int indexMin = Integer.parseInt(tempMin[1]);
                    printOddAndEven(minType, min, indexMin);
                    break;
                case "first":
                    int countFirst = Integer.valueOf(commands[1]);
                    String typeFirst = commands[2];
                    if (countFirst > numbers.length) {
                        System.out.println("Invalid count");
                    } else {
                        int[] firstElements = findingFirstNElements(numbers, countFirst, typeFirst);
                        printArrayFirstLast(firstElements);
                    }
                    break;
                case "last":
                    int countLast = Integer.valueOf(commands[1]);
                    String typeLast = commands[2];
                    if (countLast > numbers.length) {
                        System.out.println("Invalid count");
                    } else {
                        int[] lastElements = findingLastNElements(numbers, countLast, typeLast);
                        printArrayFirstLast(lastElements);
                    }
                    break;
                case "end":
                    printArray(numbers);
                    stop = false;
                    break;
                default:
                    System.out.println("Wrong action. Try again.");
                    break;
            }
        }

    }

    private static int[] findingFirstNElements(int[] numbers, int quantity, String type) {
        int[] temp = new int[quantity];
        int index = 0;
        int count = 0;
        if (quantity > numbers.length) {
            System.out.println("Invalid count");
        } else if (type.equals("even")) {
            for (int number : numbers) {
                if (number % 2 == 0) {
                    temp[index] = number;
                    index++;
                    count++;
                    if (count == quantity) {
                        break;
                    }
                }
            }
        } else if (type.equals("odd")) {
            for (int number : numbers) {
                if (number % 2 != 0) {
                    temp[index] = number;
                    index++;
                    count++;
                    if (count == quantity) {
                        break;
                    }
                }
            }
        }
        if (quantity == count) {
            return temp;
        }
        int[] first = new int[count];
        if (quantity > numbers.length) {
            return first;
        }
        System.arraycopy(temp, 0, first, 0, count);
        return first;
    }

    private static int[] findingLastNElements(int[] numbers, int quantity, String type) {
        int[] temp = new int[quantity];
        int index = 0;
        int count = 0;
        if (type.equals("even")) {
            for (int i = numbers.length - 1; i > 0; i--) {
                if (numbers[i] % 2 == 0) {
                    temp[index] = numbers[i];
                    index++;
                    count++;
                    if (count == quantity) {
                        break;
                    }
                }
            }
        } else if (type.equals("odd")) {
            for (int i = numbers.length - 1; i >= 0; i--) {
                if (numbers[i] % 2 != 0) {
                    temp[index] = numbers[i];
                    index++;
                    count++;
                    if (count == quantity) {
                        break;
                    }
                }
            }
        }
        if (quantity == count) {
            return temp;
        }
        int[] last = new int[count];
        if (quantity > numbers.length) {
            return last;
        }
        System.arraycopy(temp, 0, last, 0, count);
        return last;
    }

    private static void printOddAndEven(String type, int number, int index) {
        if (type.equals("odd")) {
            if (number % 2 != 0) {
                System.out.println(index);
            } else {
                System.out.println("No matches");
            }
        } else {
            if (number % 2 == 0) {
                System.out.println(index);
            } else {
                System.out.println("No matches");
            }
        }
    }

    private static String minValue(int[] numbers, String type) {
        int min = numbers[0];
        int index = 0;
        boolean onlyOne = true;
        for (int i = 0; i < numbers.length; i++) {
            if (type.equals("even")) {
                if (numbers[i] % 2 == 0) {
                    if (onlyOne) {
                        min = numbers[i];
                        onlyOne = false;
                    }
                    if (min >= numbers[i]) {
                        min = numbers[i];
                        index = i;
                    }
                }
            } else if (numbers[i] % 2 != 0) {
                if (onlyOne) {
                    min = numbers[i];
                    onlyOne = false;
                }
                if (numbers[i] <= min) {
                    min = numbers[i];
                    index = i;
                }
            }
        }
        return min + " " + index;
    }

    private static String maxValue(int[] numbers, String type) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (type.equals("even")) {
                if (numbers[i] % 2 == 0) {
                    if (numbers[i] >= max) {
                        max = numbers[i];
                        index = i;
                    }
                }
            } else if (numbers[i] % 2 != 0) {
                if (numbers[i] >= max) {
                    max = numbers[i];
                    index = i;
                }
            }
        }
        return max + " " + index;
    }

    private static void exchangeByGivenIndex(int[] numbers, int index) {
        if (index >= numbers.length) {
            System.out.println("Invalid index");
        } else if (index < 0){
            System.out.println("Invalid index");
        } else {
            int[] temp = new int[numbers.length];
            int curr = 0;
            for (int i = index + 1; i < numbers.length; i++) {
                temp[curr] = numbers[i];
                curr++;
            }
            for (int i = 0; i <= index; i++) {
                temp[curr] = numbers[i];
                curr++;
            }
            System.arraycopy(temp, 0, numbers, 0, numbers.length);
        }
    }

    private static void printArrayFirstLast(int[] numbers) {
        if (numbers.length != 0) {
            printArray(numbers);
        } else {
            System.out.println("[]");
        }
    }

    private static void printArray(int[] numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.length - 1; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println(numbers[numbers.length - 1] + "]");
    }
}

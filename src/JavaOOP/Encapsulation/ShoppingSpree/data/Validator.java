package JavaOOP.Encapsulation.ShoppingSpree.data;

public class Validator {
    public static boolean ValidName(String name) {
        return name.length() != 0 && !name.contains(" ");
    }

    public static boolean ValidMoney(double money) {
        return money >= 0;
    }
}

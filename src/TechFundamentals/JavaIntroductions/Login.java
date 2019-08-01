package TechModule.JavaIntroductions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userName = reader.readLine();
        String passWord = "";
        int count = 0;

        for (int i = userName.length() - 1; i >= 0; i--) {
            passWord += userName.charAt(i);
        }

        String inputPass = reader.readLine();
        while (!inputPass.equals(passWord)) {
            count ++;
            System.out.println("Incorrect password. Try again.");
            inputPass = reader.readLine();
            if (count == 3) {
                System.out.println("User " + userName + " blocked!");
                return;
            }
        }
        System.out.println("User " + userName + " logged in.");
    }
}

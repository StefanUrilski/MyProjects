package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fibonacci {

    private static long[] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        memory = new long[n+1];

        long fibo = calcFibo(n);

        System.out.println(fibo);

    }

    private static long calcFibo(int n) {

        if (n < 2) {
            return 1;
        }
        if (memory[n] != 0) {
            return memory[n];
        }

        return  memory[n] = calcFibo(n - 1) + calcFibo(n - 2);
    }
}

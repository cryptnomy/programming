package sds_algorithm.src.DAY01.DFS;

import java.io.IOException;

public class Fibonacci {
    static int fib(int n) {
        if (n == 1 || n == 2)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(fib(4));
    }
}

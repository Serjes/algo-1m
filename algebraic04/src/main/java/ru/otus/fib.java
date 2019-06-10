package ru.otus;

public class fib {
    public static void main(String[] args) {
        System.out.println(fibRun(1200));
    }

    private static double fibRun(int n) {
        double a = 1;
        double b = 1;
//        int f = 1;
        double f = 0;

        for (int i = 3; i <= n; i++) {
            f = a + b;
            a = b;
            b = f;
        }

        return f;
    }
}

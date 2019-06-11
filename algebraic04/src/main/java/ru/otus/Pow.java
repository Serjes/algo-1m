package ru.otus;

public class Pow {
    public static void main(String[] args) {

        System.out.println(binaryPow(2,10));

//        System.out.println(simplePow(13,11));
//        System.out.println(binaryPow(13,11));
//        System.out.println(binaryDecompositionPow(13,11));
    }

    public static long simplePow(long base, long power) {

        long result = base;
        for (int i = 1; i < power; i++) {
             result *= base;
        }
        return result;
    }

    public static long binaryPow(long base, long power) {
        long k = power / 2;

        long remainder = power % 2;
        long result = base;
        for (int i = 1; i < k; i++) {
            result *= result;
        }
        for (int i = 0; i < remainder; i++) {
            result *= base;
        }

        return result;

    }

    public static long binaryDecompositionPow(long base, long power) {

        long result = 1;

        while (power > 1) {
            if (power % 2 == 1) result *= base;
            base *= base;
            power /= 2;
        }
        if (power > 0) result *= base;

        return result;

    }
}

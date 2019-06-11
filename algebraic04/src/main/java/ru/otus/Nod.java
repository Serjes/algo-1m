package ru.otus;

public class Nod {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(gcd(123456789000L, 12L));
        System.out.println((System.currentTimeMillis() - start) + " мс");
    }


    public static long gcd(long  a, long b) {
        while (a != b) {
            if (a > b){
                a -= b;
            }
            else {
                b -= a;
            }
        }
        return a;
    }

    public static  long enhancedGcd(long  a, long b){
        while ((a != 0) && (b != 0)) {
            if (a > b){
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        return a + b;

    }
}

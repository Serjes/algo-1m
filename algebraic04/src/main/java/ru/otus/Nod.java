package ru.otus;

public class Nod {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(nod(123456789000L, 12L));
        System.out.println(
                (System.currentTimeMillis() - start));
    }


    public static long nod(long  a, long b) {
        while (a != b) {
            if (a > b){
                a = a - b;
            }
            else {
                b = b - a;
            }
        }
        return a;
    }

    public static  long enhNod(long  a, long b){
        while (a != b) {
            if (a > b){
                a = a - b;
            }
            else {
                b = b - a;
            }
        }
        return a;

    }
}

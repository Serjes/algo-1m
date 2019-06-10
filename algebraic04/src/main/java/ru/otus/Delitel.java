package ru.otus;

public class Delitel {

    public static void main(String[] args) {
        System.out.println(del(10000));
    }

    public static int del(int n){

        int count2 = 0;
        for (int j = 1; j < n; j++) {

            int count = 0;
            for (int i = 1; i < j; i++) {
                if (j % i == 0) {
                    count++;
                }
                if (count > 2) break;

            }
            if (count == 2) count2++;
//            return count;
        }
        return count2;
    }
}

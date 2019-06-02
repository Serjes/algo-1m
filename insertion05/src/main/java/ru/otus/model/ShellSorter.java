package ru.otus.model;

import java.util.Arrays;

public class ShellSorter implements ISorter {
    private int[] gaps; // length 20 - десятки миллионов
    private int seqNumber;

    public ShellSorter() {
        this(1);
    }

    public ShellSorter(int seqNumber) {
        this.seqNumber = seqNumber;
        switch (this.seqNumber) {
            case 2:
                gap2();
                break;
            case 3:
                gap3();
                break;
            case 4:
                gap4();
                break;
            case 1:
            default:
                gap1();
                break;
        }
    }

    private void gap1() { //2 ^ K - 1
        gaps = new int[20];
        int accum = 1;
        for (int i = 0; i < gaps.length; i++) {
            gaps[i] = 2 * accum - 1;
            accum = accum * 2;
        }
    }

    private void gap2() { //2 ^ K + 1
        gaps = new int[20];
        int accum = 1;
        gaps[0] = 1;
        for (int i = 1; i < gaps.length; i++) {
            gaps[i] = 2 * accum + 1;
            accum = accum * 2;
        }
    }

    private void gap3() { //4 ^ K + 3 * 2 ^ K-1 + 1
        gaps = new int[20];
        int accum4 = 4;
        int accum2 = 1;
        gaps[0] = 1;
        gaps[1] = 8;
        for (int i = 2; i < gaps.length; i++) {
            gaps[i] = 4 * accum4 + 3 * 2 * accum2 + 1;
            accum4 = accum4 * 4;
            accum2 = accum2 * 2;
        }
    }

    private void gap4() { //Unknown
        gaps = new int[]{1, 4, 10, 23, 57, 145, 356, 911, 1968, 4711, 11969, 27901, 84801, 213331, 543749, 1355339,
                3501671, 8810089, 21521774, 58548857};
    }


    @Override
    public void apply(int[] array) {

        int len = array.length;
        int q = 0;
        while (gaps[q] < len) q++;
        while (q >= 0) {
            int k = gaps[q];
            for (int i = k; i < array.length; i++) {
                int x = array[i];
                int j = i - k;
                while ((j >= 0) && (array[j] > x)) {
                    array[j + k] = array[j];
                    j -= k;
                }
                array[j + k] = x;
            }
            q--;
        }
    }

    private void printGaps() {
        System.out.println("Shell sort, gaps:");
        Arrays.stream(gaps).forEach(x -> System.out.print(x + " "));
    }
}

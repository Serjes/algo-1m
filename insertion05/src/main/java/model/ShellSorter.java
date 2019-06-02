package model;

import java.util.Arrays;

public class ShellSorter implements ISorter {
    private int[] gaps = new int[20]; // до миллиона
    ISorter auxSort = new InsertionSorter();

    public ShellSorter() {
        int accum = 1;
        for (int i = 0; i < gaps.length; i++) {
            gaps[i] = 2 * accum - 1;
            accum = accum *2 ;
        }
    }

    @Override
    public void apply(int[] array) {

        int len = array.length;
        System.out.println("Shell sort, gaps:");
        Arrays.stream(gaps).forEach(x -> System.out.print(x + " "));
        int j = 0;
        while (gaps[j] < len) j++;
        System.out.println("\n" + gaps[--j]); //

//        j = 0;
        while (j > 0) {

        }

    }
}

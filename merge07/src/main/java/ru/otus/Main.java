package ru.otus;

import ru.otus.model.ISorter;
import ru.otus.model.MergeInsertionSorter;
import ru.otus.model.MergeSorter;
import ru.otus.model.QuickSorter;

import java.util.Arrays;
import java.util.Random;

public class Main {

//    public static final int ARRAY_SIZE = 5;
    public static final int ARRAY_SIZE = 30;

    public static void main(String[] args) {

        int[] arr = new int[ARRAY_SIZE];
        Random rnd = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            arr[i] = rnd.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));
        ISorter sorter = new MergeInsertionSorter();
//        ISorter sorter = new QuickSorter();
        sorter.apply(arr);
        System.out.println(Arrays.toString(arr));
    }
}

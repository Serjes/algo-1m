package ru.otus;

import ru.otus.model.ISorter;
import ru.otus.model.MergeSorter;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static final int ARRAY_SIZE = 4;

    public static void main(String[] args) {

        int[] arr = new int[ARRAY_SIZE];
        Random rnd = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            arr[i] = rnd.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));
        ISorter sorter = new MergeSorter();
        sorter.apply(arr);
        System.out.println(Arrays.toString(arr));
    }
}

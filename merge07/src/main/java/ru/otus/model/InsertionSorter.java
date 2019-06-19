package ru.otus.model;

import java.util.Arrays;

public class InsertionSorter implements ISorter {
    @Override
    public void apply(int[] array) {

        sort(array, 0, array.length);

    }

    public void sort(int[] array, int begin, int end) {

        for (int i = begin; i < end; i++) {
            int x = array[i];
            int j = i - 1;
            while((j >= begin) && (array[j] > x)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = x;
        }
    }
}

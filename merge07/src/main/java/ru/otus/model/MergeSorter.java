package ru.otus.model;

import java.util.Arrays;

public class MergeSorter implements ISorter {
    @Override
    public void apply(int[] array) {
        int[] copyOfArray = Arrays.copyOf(array, array.length);
        splitMerge(copyOfArray, 0, array.length, array);
    }

    private void splitMerge(int[] copy, int begin, int end, int[] array) {
        if ((end - begin) < 2) return;
        int middle = (end + begin) / 2;
        splitMerge(array, begin, middle, copy);
        splitMerge(array, middle, end, copy);
        merge(copy, begin, middle, end, array);
    }

    private void merge(int[] array, int begin, int middle, int end, int[] copy) {
        int first = begin;
        int second = middle;
        for (int i = begin; i < end ; i++) {
            if ((first < middle) && ((second >= end) || (array[first] <= array[second]))) {
                copy[i] = array[first];
                first++;
            } else {
                copy[i] = array[second];
                second++;
            }

        }
    }
}

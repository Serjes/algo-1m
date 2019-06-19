package ru.otus.model;

public class QuickSorter implements ISorter {
    @Override
    public void apply(int[] array) {
        quicksort(array, 0, array.length);
    }

    private void quicksort(int[] array, int begin, int end) {
        if (begin < end) {
            int pivot = partition(array, begin, end);
            quicksort(array, begin, pivot);
            quicksort(array, pivot + 1, end);
        }
    }

    private int partition(int[] array, int begin, int end) {
        int pivot = array[end - 1];
        int i = begin - 1;
        for (int j = begin; j < end - 1; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, j, i);
            }
        }
        swap(array, i + 1, end - 1);
        return ++i;
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}

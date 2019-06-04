package ru.otus.model;

public class InsertionSorter implements ISorter {
    @Override
    public void apply(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int x = array[i];
            int j = i - 1;
            while((j >= 0) && (array[j] > x)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = x;
        }
    }
}

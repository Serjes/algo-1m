package ru.otus;

import ru.otus.model.Heap;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static final int ARRAY_SIZE = 11;

    public static void main(String[] args) {
        int[] arr = new int[ARRAY_SIZE];
        Random rnd = new Random();
        for (int i = 0; i < 11; i++) {
            arr[i] = rnd.nextInt(100);
        }
//        int[] arr = {9, 5, 10, 8, 2, 1, 0, 3, 11, 4, 6, 7};
//        int[] arr = {55, 2, 93, 1, 23, 10, 66, 12, 7, 54, 3};

        System.out.println(Arrays.toString(arr));
        System.out.println("\nТеперь построим Heap:");
        Heap heap = new Heap();
//        heap.buildHeap(arr);
        heap.sortByHeap(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }
}

package ru.otus.model;

public class Heap {

    public void sortByHeap(int[] arr) {
        buildHeap(arr);
        int sizeArray = arr.length;
        for (int i = sizeArray - 1; i > 0; i--) {
            swapForHeap(arr, i, 0);
            sizeArray--;
            drown(arr, 0, sizeArray);
        }
    }

    public void buildHeap(int[] arr) {
        for (int i = (arr.length - 1)/2; i >= 0; i--) {
            drown(arr, i, arr.length);
        }
    }

    private void drown(int[] heapArray, int index, int heapSize) {
        int indexOfLeft = getIndexOfLeft(index);
        int indexOfRight = getIndexOfRight(index);
        int largest = 0;
        if ((indexOfLeft < heapSize) && (heapArray[indexOfLeft] > heapArray[index])) {
            largest = indexOfLeft;
        } else {
            largest = index;
        }

        if ((indexOfRight < heapSize) && (heapArray[indexOfRight] > heapArray[largest]))
            largest = indexOfRight;

        if (largest != index) {
            swapForHeap(heapArray, index, largest);
            drown(heapArray, largest, heapSize);
        }

    }

    private void swapForHeap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private int getIndexOfRight(int index) {
        return index * 2 + 2;
    }

    private int getIndexOfLeft(int index) {
        return index * 2 + 1;
    }
}

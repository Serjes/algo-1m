import model.*;

import java.util.Date;
import java.util.Random;

public class Main {

    public static final int TOTAL = 100_000;

    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PQueueWrapper<>();
        PriorityQueue<Integer> queue = new ListPQueue<>();
        queue.enqueue(0, 10);
        queue.enqueue(0, 12);
        queue.enqueue(0, 16);
        queue.enqueue(2, 102);
        queue.enqueue(3, 103);
        queue.enqueue(1, 101);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

//        compareSpeed();
//        testAddingAndRemovingByIndex();
    }

    private static void compareSpeed() {
        IArray singleArray = new SingleArray();
        IArray vectorArray = new VectorArray();
        IArray factorArray = new FactorArray();
        IArray matrixArray = new MatrixArray();
        IArray arlistArray = new ArrayListWrapper();
        testAddArray(singleArray, TOTAL);
        testAddArray(vectorArray, TOTAL);
        testAddArray(factorArray, TOTAL);
        testAddArray(matrixArray, TOTAL);
        testAddArray(arlistArray, TOTAL);
    }

    private static void testAddingAndRemovingByIndex() {
        Random rnd = new Random();
//        IArray curArray = new SingleArray();
        IArray curArray = new VectorArray();
//        IArray curArray = new FactorArray();
        for (int i = 0; i < 46; i++) {
            curArray.add(rnd.nextInt(100));
        }
        System.out.println("\nTesting for adding and removing by index:");
        printArr(curArray);
        curArray.add(100, 5);
        System.out.println("insert 100 at index 5: ");
        printArr(curArray);
        System.out.println("arr(4) = " + curArray.remove(4) + " was removed: ");
        printArr(curArray);
        System.out.println("arr(24) = " + curArray.remove(24) + " was removed: ");
        printArr(curArray);
        System.out.println("Init MatrixArray:");
        IArray curMatrixArray = new MatrixArray();
        for (int i = 0; i < 46; i++) {
            curMatrixArray.add(i);
        }
        printMatrixArr(curMatrixArray);
        curMatrixArray.add(111, 13);
        System.out.println("after adding: ");
        printMatrixArr(curMatrixArray);
        curMatrixArray.remove(13);
        System.out.println("after remove: ");
        printMatrixArr(curMatrixArray);
    }

    private static void printArr(IArray singleArray2) {
        for (int i = 0; i < singleArray2.size(); i++) {
            System.out.printf("%4d ", singleArray2.get(i));
        }
        System.out.println("");
    }

    private static void printMatrixArr(IArray arr) {
        for (int i = 0; i <= (arr.size() / MatrixArray.VECTOR); i++) {
            for (int j = 0; (j < MatrixArray.VECTOR) && (j + i * 10 < arr.size()); j++) {
                System.out.printf("%4d ", arr.get(i * 10 + j));
            }
            System.out.println("");
        }
    }

    private static void testAddArray(IArray data, int total) {
        long start = System.currentTimeMillis();

        for (int j = 0; j < total; j++)
            data.add(new Date());

        System.out.println(data + " testAddArray: " +
                (System.currentTimeMillis() - start));

    }
}

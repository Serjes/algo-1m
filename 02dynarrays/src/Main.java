import model.*;

import java.util.Arrays;
import java.util.Date;

public class Main {

//    public static final int TOTAL = 100_000;
    public static final int TOTAL = 1_000;

    public static void main(String[] args) {
        IArray singleArray = new SingleArray();
//        IArray vectorArray = new VectorArray();
//        IArray factorArray = new FactorArray();
//        IArray matrixArray = new MatrixArray();
        testAddArray(singleArray, TOTAL);
//        testAddArray(vectorArray, TOTAL);
//        testAddArray(factorArray, TOTAL);
//        testAddArray(matrixArray, TOTAL);

//        IArray curArray = new SingleArray();
//        IArray curArray = new VectorArray();
//        IArray curArray = new FactorArray();
        IArray curArray = new MatrixArray();
        for (int i = 0; i < 30; i++) {
            curArray.add(i);
        }
        printArr(curArray);
//        curArray.add(100, 5);
//        printArr(curArray);
//        System.out.println("item = " + curArray.remove(4) + " was removed");
//        printArr(curArray);
//        System.out.println("item = " + curArray.remove(24) + " was removed");
//        printArr(curArray);
    }

    private static void printArr(IArray singleArray2) {
        for (int i = 0; i < singleArray2.size(); i++) {
            System.out.printf("%4d ", singleArray2.get(i));
        }
        System.out.println("");
    }

    private static void testAddArray(IArray data, int total){
        long start = System.currentTimeMillis();

        for(int j = 0; j < total; j++)
            data.add(new Date());

        System.out.println(data + " testAddArray: " +
                (System.currentTimeMillis() - start));

    }
}

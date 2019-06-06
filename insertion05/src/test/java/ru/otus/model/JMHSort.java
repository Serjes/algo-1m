package ru.otus.model;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(value = Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JMHSort {
//    private static final int ARRAY_SIZE = 100_000;
    private static final int ARRAY_SIZE = 163840;
//    private static final int ARRAY_SIZE = 81920;
//    private static final int ARRAY_SIZE = 40960;
//    private static final int ARRAY_SIZE = 20480;
//    private static final int ARRAY_SIZE = 10240;
//    private static final int ARRAY_SIZE = 5120;
//    private static final int ARRAY_SIZE = 2560;
//    private static final int ARRAY_SIZE = 1280;
//    private static final int ARRAY_SIZE = 640;
//    private static final int ARRAY_SIZE = 320;
//    private static final int ARRAY_SIZE = 160;
//    private static final int ARRAY_SIZE = 80;
//    private static final int ARRAY_SIZE = 40;
//    private static final int ARRAY_SIZE = 20;
    private int[] arr1 = new int[ARRAY_SIZE];
    private int[] arr2 = new int[ARRAY_SIZE];
    private int[] arr3 = new int[ARRAY_SIZE];
    private int[] arr4 = new int[ARRAY_SIZE];
    private int[] arr5 = new int[ARRAY_SIZE];
    private ISorter sorter1;
    private ISorter sorter2;
    private ISorter sorter3;
    private ISorter sorter4;
    private ISorter sorter5;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(JMHSort.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }

    @Setup
    public void setup() {
        Random rnd = new Random();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            arr1[i] = i;
        }
//        for (int i = 0; i < ARRAY_SIZE / 10; i++) {
//            int index = rnd.nextInt(ARRAY_SIZE);
//            arr1[index] = rnd.nextInt(1000);
//        }
        for (int i = 0; i < 5; i++) {
            int index = rnd.nextInt(ARRAY_SIZE);
            arr1[index] = rnd.nextInt(1000);
        }

        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr1, 0, arr4, 0, arr1.length);
        System.arraycopy(arr1, 0, arr5, 0, arr1.length);
        sorter1 = new ShellSorter(1);
        sorter2 = new ShellSorter(2);
        sorter3 = new ShellSorter(3);
        sorter4 = new ShellSorter(4);
        sorter5 = new InsertionSorter();
    }

    @Benchmark
    public void shellSortSeq1() {
        sorter1.apply(arr1);
    }

    @Benchmark
    public void shellSortSeq2() {
        sorter2.apply(arr2);
    }

    @Benchmark
    public void shellSortSeq3() {
        sorter3.apply(arr3);
    }

    @Benchmark
    public void shellSortSeq4() {
        sorter4.apply(arr4);
    }

    @Benchmark
    public void insertionSort() {
        sorter5.apply(arr5);
    }
}

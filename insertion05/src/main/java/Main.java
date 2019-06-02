import model.ISorter;
import model.InsertionSorter;
import model.ShellSorter;

//import java.util.Arrays;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static final int ARRAY_SIZE = 100;
//    public static final int ARRAY_SIZE = 10;

    public static void main(String[] args) {
        int[] arr = new int[ARRAY_SIZE];
        Random rnd = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            arr[i] = rnd.nextInt(100);
        }
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));

//        ISorter sorter = new InsertionSorter();
//        sorter.apply(arr);

//        System.out.println("\nAfter sorting: ");
//        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));

        ISorter sorter2 = new ShellSorter();
        sorter2.apply(arr);

        System.out.println("\nAfter sorting: ");
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }
}

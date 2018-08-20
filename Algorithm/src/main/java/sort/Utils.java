package sort;

/**
 * Created by yjw on 18-7-2.
 */
public class Utils {
    public static void printArray(int[] array) {
        for (int elem : array) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void swap(int[] array, int a, int b) {
        array[a] = array[a] + array[b];
        array[b] = array[a] - array[b];
        array[a] = array[a] - array[b];
    }
}

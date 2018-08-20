package sort;

/**
 * Created by yjw on 18-7-2.
 */


/**
 * O(N^2)
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {34, 8 ,64, 51, 32, 21};
        System.out.println("before:");
        Utils.printArray(array);
        sort(array);
        System.out.println("after:");
        Utils.printArray(array);
    }

    public static void sort(int[] array) {
        for (int i=1; i<array.length; i++) {
            int temp = array[i];
            int j;
            for (j=i; j>0 && temp<array[j-1];j--) {
                array[j] = array[j-1];
            }
            array[j] = temp;
        }
    }
}

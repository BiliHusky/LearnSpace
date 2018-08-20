package sort;

/**
 * Created by yjw on 18-7-2.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 76};
        Utils.printArray(array);
        sort(array);
        Utils.printArray(array);
    }

    public static void sort(int[] array) {
        for (int i=0; i<array.length-1; i++) {
            for (int j=i+1; j<array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}

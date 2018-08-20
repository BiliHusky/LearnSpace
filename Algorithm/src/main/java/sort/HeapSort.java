package sort;

/**
 * Created by yjw on 18-7-3.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = {34, 8 ,64, 51, 32, 21};
        System.out.println("before:");
        Utils.printArray(array);
        sort(array);
        System.out.println("after:");
        Utils.printArray(array);
    }

    public static void sort(int[] array) {
        for(int i=array.length/2-1;i>=0; i--) {
            adjustHeap(array, i, array.length);
        }

        for(int j=array.length-1; j>0; j--) {
            Utils.swap(array,0, j);
            adjustHeap(array, 0, j);
        }
    }

    public static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        for (int k=i*2+1; k<length; k=k*2+1) {
            if (k+1<length && array[k] < array[k+1]) {
                k++;
            }

            if (array[k] > temp) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }
        array[i] = temp;
    }
}

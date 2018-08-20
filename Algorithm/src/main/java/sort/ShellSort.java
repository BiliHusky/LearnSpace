package sort;

/**
 * Created by yjw on 18-7-2.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {34, 8 ,64, 51, 32, 21};
        System.out.println("before:");
        Utils.printArray(array);
        sort1(array);
        System.out.println("after:");
        Utils.printArray(array);
    }

    public static void sort(int[] array) {
        for (int gap = array.length /2; gap >0; gap/=2) {
            for(int i=gap; i<array.length; i++) {
                int j=i;
                while(j-gap>=0 && array[j] < array[j-gap]) {
                    swap(array, j, j-gap);
                    j-=gap;
                }
            }
        }
    }

    public static void sort1(int[] array) {
        for (int gap = array.length/2; gap>0; gap/=2) {
            for (int i=gap; i<array.length; i++) {
                int j = i;
                int temp = array[j];
                while (j-gap >= 0 && temp < array[j-gap]) {
                    array[j] = array[j-gap];
                    j-=gap;
                }
                array[j] = temp;
            }
        }
    }

    public static void swap(int[] array, int a, int b) {
        array[a] = array[a] + array[b];
        array[b] = array[a] - array[b];
        array[a] = array[a] - array[b];
    }
}

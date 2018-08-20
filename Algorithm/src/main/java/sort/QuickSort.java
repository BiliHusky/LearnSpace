package sort;

/**
 * Created by yjw on 18-7-2.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {34, 8 ,64, 51, 32, 21};
        System.out.println("before:");
        Utils.printArray(array);
        sort(array);
        System.out.println("after:");
        Utils.printArray(array);
    }

    public static void sort(int[] array) {
        System.out.println("num :" + quicksort2(0, array.length-1, array, 2));
    }

    public static void quickSort(int left, int right, int[] array) {
        int i,j;
        if (left > right)
            return;
        int temp = array[left];
        i = left;
        j = right;

        while(i!=j) {
            while(array[j] >= temp && i<j) {
                j--;
            }
            while(array[i] <= temp && i<j) {
                i++;
            }

            if(i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }

        array[left] = array[i];
        array[i] = temp;

        quickSort(left, i-1, array);
        quickSort(i+1, right, array);
    }


    public static int quicksort2(int left, int right, int[] array, int k) {
        int i = left;
        int j = right;

        if (left > right) {
            return -1;
        }

        int temp = array[left];

        while (i!=j) {
            while (array[j]>=temp && i<j) {
                j--;
            }

            while (array[i]<=temp && i<j) {
                i++;
            }

            if(i<j) {
                Utils.swap(array,i,j);
            }
        }

        array[left] = array[i];
        array[i] = temp;

        if (i == k) {
            return temp;
        } else {
            int leftpart=quicksort2(left, i - 1, array, k);
            int rightpart=quicksort2(i + 1, right, array, k);

            return leftpart > rightpart ? leftpart : rightpart;
        }
    }


}

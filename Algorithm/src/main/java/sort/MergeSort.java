package sort;

/**
 * Created by yjw on 18-7-2.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {34, 8 ,64, 51, 32, 21};
        System.out.println("before:");
        Utils.printArray(array);
        sort(array);
        System.out.println("after:");
        Utils.printArray(array);
    }

    public static void sort(int[] array) {
        int[] temp = new int[array.length];
        sort(array,0, array.length-1, temp);
    }

    public static void sort(int[] array, int left, int right, int[] temp){
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, left, mid, temp);
            sort(array, mid+1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i=left;
        int j=mid+1;
        int temp_loc = 0;
        while (i<=mid && j<=right) {
            if(array[i] <= array[j]) {
                temp[temp_loc++] = array[i++];
            } else {
                temp[temp_loc++] = array[j++];
            }
        }

        while (i<=mid) {
            temp[temp_loc++] = array[i++];
        }

        while (j<=right) {
            temp[temp_loc++] = array[j++];
        }
        temp_loc = 0;
        while(left<=right) {
            array[left++] = temp[temp_loc++];
        }
    }
}

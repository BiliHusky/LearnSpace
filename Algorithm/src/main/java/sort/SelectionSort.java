package sort;

/**
 * Created by yjw on 18-7-2.
 */

/***
 *  O(N^2)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arry = {1, 3, 2, 45, 65, 33, 12};
        System.out.println("before sort: ");
        Utils.printArray(arry);
        sort(arry);
        Utils.printArray(arry);
    }

    public static void sort(int[] arry) {
        for (int i=0; i<arry.length-1; i++) {
            int minLoc = i;
            for (int j=i+1; j<arry.length; j++) {
                if (arry[j] < arry[minLoc]) {
                    minLoc = j;
                }
            }

            if (minLoc != i) {
                int temp = arry[i];
                arry[i] = arry[minLoc];
                arry[minLoc] = temp;
            }
        }
    }
}

package sort;

/**
 * Created by yjw on 18-6-29.
 */
public class DirectInsertSort {
    public static void main(String[] args) {
        int[] a = {49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("before:");
        for (int elem : a) {
            System.out.print(elem + " ");
        }

        for (int i=1; i<a.length; i++) {
            int temp = a[i];
            int j;
            for (j=i-1; j>=0; j--) {
                if (a[j] > temp) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = temp;
        }
        System.out.println();
        System.out.println("after:");
        for (int elem : a) {
            System.out.print(elem + " ");
        }
    }
}

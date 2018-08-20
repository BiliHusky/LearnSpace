package sort;

/**
 * Created by yjw on 18-6-29.
 */
public class BinaryInsertSort {
    public static void main(String[] args) {
        int[] a = {49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("before:");
        for (int elem : a) {
            System.out.print(elem + " ");
        }
        sort(a);
        System.out.println();
        System.out.println("after:");
        for (int elem : a) {
            System.out.print(elem + " ");
        }
    }

    private static void sort(int[] a) {
        for (int i=0; i<a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i-1;
            int mid = 0;
            while(left <= right) {
                mid = (left + right) / 2;
                int t = (temp < a[mid]) ? (right = mid -1) : (left = mid +1) ;
            }
            for (int j=i-1; j>=left; j--) {
                a[j+1] = a[j];
            }
            if (i!=left) {
                a[left] = temp;
            }
        }
    }
}

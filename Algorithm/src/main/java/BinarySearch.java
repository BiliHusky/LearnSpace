/**
 * Created by yjw on 18-3-7.
 */
public class BinarySearch {

    public int Binary_Search(int[] a, int low, int high, int item) {
        int mid = (low + high) / 2;
        int value_mid = a[mid];
        if (value_mid == item)
            return mid;
        else if (value_mid > item) {
            high = mid -1;
            return Binary_Search(a, low, high, item);
        } else {
            low = mid + 1;
            return Binary_Search(a, low, high, item);
        }
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        BinarySearch b = new BinarySearch();
        System.out.println(b.Binary_Search(a, 0 , 4, 1));
    }
}

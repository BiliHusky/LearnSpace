package com.yjw.interview.alg.sort;

/**
 * @author David Yang
 * @date 2020-02-26 17:58
 */
public class Search {
    public static int search(int[] arr, int target, int left, int right) {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;
        if (target == arr[mid])
            return mid;

        return arr[mid] < target ? search(arr, target, mid + 1, right) : search(arr, target, left, mid -1);
    }

    public static void main(String[] args) {
        int[] arr = { 1,2 ,3, 4, 5};
        System.out.println(search(arr,5, 0, arr.length));

    }
}

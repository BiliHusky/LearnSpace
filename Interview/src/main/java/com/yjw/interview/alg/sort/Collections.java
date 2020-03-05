package com.yjw.interview.alg.sort;

import com.yjw.interview.alg.utils.ArrayUtils;
import com.yjw.interview.alg.utils.DisplayUtil;

/**
 * @author David Yang
 * @date 2020-02-27 13:32
 */
public class Collections {

    public static void InsertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int tmp = arr[i];
            while (j >= 0 && tmp < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = tmp;
        }
    }

    public static void BubbleSort(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            for (int j=n-1; j>i; j--) {
                if (arr[j] < arr[j-1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }

    public static void quickSort(int[] arr) {
        quickSortSub(arr, 0, arr.length -1);
    }

    public static void quickSortSub(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int tmp = arr[i];

            while (i < j) {
                while (i < j && arr[j] > tmp) {
                    j--;
                }

                if (i < j) {
                    arr[i] = arr[j];
                }

                while (i < j && arr[i] < tmp) {
                    i++;
                }

                if (i < j) {
                    arr[j] = arr[i];
                }
            }

            arr[i] = tmp;
            quickSortSub(arr, left, i-1);
            quickSortSub(arr, i+1, right);
        }
    }

    public static void heapSort(int[] arr) {
        for (int i=arr.length/2 -1; i>=0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int i=arr.length-1; i>0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int tmp = arr[i];

        for (int k=i*2+1; k < length; k=k*2+1) {
            if (k +1 < length && arr[k] < arr[k+1]) {
                k++;
            }

            if (arr[i] < arr[k]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }

    public static void mergeSort(int arr[]) {
        merge(arr, 0, arr.length-1);
    }

    public static void merge(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) /2;
            merge(arr, left, mid);
            merge(arr, mid+1, right);
            mergeS(arr, left, mid, right);
        }
    }

    public static void mergeS(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i=left, j=mid+1, k=0;
        while (i<=mid && j<=right) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        while (i<=mid)
            tmp[k++] = arr[i++];

        while (j<=right)
            tmp[k++] = arr[j++];

        k=0;
        for (int l=left; l<=right; l++) {
            arr[l] = tmp[k++];
        }
    }



    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 2, 5};
        //InsertSort(arr);
//        BubbleSort(arr);
//        quickSort(arr);
//        heapSort(arr);
        mergeSort(arr);
        DisplayUtil.showArray(arr);
    }
}

package com.yjw.interview.alg.sort;

import com.yjw.interview.alg.utils.ArrayUtils;

/**
 *   归并排序
 *      归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 *   算法描述
 *      把长度为n的输入序列分成两个长度为n/2的子序列；
 *      对这两个子序列分别采用归并排序；
 *      将两个排序好的子序列合并成一个最终的排序序列。
 */
public class MergeSort {

    private static void sort(Integer[] array) {
    }

    private static void mergeData(Integer[] array, int left, int mid, int right) {
        Integer[] tmparry = new Integer[array.length];

        int i = left;
        int j = mid;
        int tmpLoc = 0;
        while (i<mid && j<right) {
            if (array[i] > array[j]) {
                tmparry[tmpLoc++] = array[i++];
            } else {
                tmparry[tmpLoc++] = array[j++];
            }
        }

        while (i<=mid) {
            tmparry[tmpLoc++] = array[i++];
        }
        while (j<=right) {
            tmparry[tmpLoc++] = array[j++];
        }
        tmpLoc = 0;
        for (int k=left; k<right; k++) {
            array[k] = tmparry[tmpLoc++];
        }
    }



}

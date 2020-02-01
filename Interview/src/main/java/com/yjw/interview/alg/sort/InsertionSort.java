package com.yjw.interview.alg.sort;

import com.yjw.interview.alg.utils.ArrayUtils;
import com.yjw.interview.alg.utils.DisplayUtil;

/**
 *   插入排序
 *      插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 *   算法描述
 *      一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 *          从第一个元素开始，该元素可以认为已经被排序；
 *          取出下一个元素，在已经排序的元素序列中从后向前扫描；
 *          如果该元素（已排序）大于新元素，将该元素移到下一位置；
 *          重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 *          将新元素插入到该位置后；
 *          重复步骤2~5。
 *    时间复杂度 avg O(n^2) bad O(n^2) best O(n)
 *    空间复杂度 O(1)
 *    稳定
 */
public class InsertionSort {
    private static void sort(Integer[] array) {
        for (int i=1; i<array.length; i++) {
            for (int j=i; j-1 >=0 && array[j] < array[j-1]; j--) {
                ArrayUtils.swap(array, j, j-1);
            }
        }
    }

    private static void sort2(Integer[] array) {
        for (int i=1; i< array.length; i++) {
            for (int j=i; j-1 >=0 && array[j] > array[j-1]; j--) {
                ArrayUtils.swap(array, j, j-1);
            }
        }
    }

    public static void main(String[] args ) {
        Integer[] array = new Integer[] {1,3,2,4,6,5};
        DisplayUtil.showArray(array);
        System.out.println();
        sort(array);
        DisplayUtil.showArray(array);
        System.out.println();
        sort2(array);
        DisplayUtil.showArray(array);
    }
}

package com.yjw.interview.alg.sort;

import com.yjw.interview.alg.utils.ArrayUtils;
import com.yjw.interview.alg.utils.DisplayUtil;

/**
 *   希尔排序
 *      1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 *   算法描述
 *      先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 *          选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 *          按增量序列个数k，对序列进行k 趟排序；
 *          每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *   时间复杂度 avg O(n^1.3~2) bad O(n^2) best O(n)
 *   空间复杂度 O(1)
 *   不稳
 */
public class ShellSort {

    private static void sort(Integer[] array) {
        for (int gap = array.length / 2; gap > 0; gap = gap/2) {
            for (int i=0; i+gap < array.length; i++) {
                for (int j=i; j+gap < array.length && array[j] > array[j+gap]; j=j+gap) {
                    ArrayUtils.swap(array, j, j+gap);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {1,3,2,5,4,6};
        DisplayUtil.showArray(array);
        System.out.println();
        sort(array);
        DisplayUtil.showArray(array);
    }
}

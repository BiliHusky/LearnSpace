package com.yjw.interview.alg.utils;

public class DisplayUtil {

    public static <T> void showArray(T[] array) {
        if (array == null || array.length <= 0)
            return;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print("  ");
        }
    }

    public static void showArray(int[] array) {
        if (array == null || array.length <= 0)
            return;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print("  ");
        }
    }
}

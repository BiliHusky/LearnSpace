package com.yjw.interview.alg.utils;

public class ArrayUtils {
    public static <T> void swap(T[] array, int x, int y) {
        if (array == null || array.length <= 0)
            throw new RuntimeException("cannot swap empty elem");
        if (x < 0 || x > array.length || y < 0 || y > array.length)
            throw new RuntimeException("index is invalid");

        T temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}


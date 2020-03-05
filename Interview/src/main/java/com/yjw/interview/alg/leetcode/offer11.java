package com.yjw.interview.alg.leetcode;

/**
 * @author David Yang
 * @date 2020-02-22 15:19
 */
public class offer11 {
    public static int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return -1;
        int loc=0;
        for (int i=0; i < numbers.length -1; i++) {
            if (numbers[i] > numbers[i+1])
                return numbers[i+1];
        }
        return numbers[0];
    }

    public static void main(String[] args) {
//        int num[] = {3,4,5,1,2};
//        int num[] = {2,2,2,0,1};
        int num[] = {2,2,2,2,2,2};
        System.out.println(minArray(num));
    }
}

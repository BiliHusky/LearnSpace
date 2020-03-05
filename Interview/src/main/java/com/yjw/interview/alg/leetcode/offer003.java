package com.yjw.interview.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author David Yang
 * @date 2020-02-22 13:04
 */
public class offer003 {
    public static int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i : nums) {
            if (counter.get(i) == null) {
                counter.put(i, 1);
            } else {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,4,4,3};
        System.out.println(findRepeatNumber(nums));
    }
}

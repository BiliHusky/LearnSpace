package com.yjw.interview.alg.leetcode;

/**
 * @author David Yang
 * @date 2020-02-22 13:12
 */
public class offer004 {

    public static void main(String[] args) {
        int arr[][] = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30} };

//        int arr[][] = {{-5}};
        System.out.println(findNumberIn2DArray(arr, 5));
        System.out.println(findNumberIn2DArray(arr,-10));

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int width = matrix[0].length;
        int height = matrix.length;
        int locx = 0;
        int locy = width - 1;
        while (locx < height && locy >=0) {
            int num = matrix[locx][locy];
            if (num == target) {
                return true;
            } else if (num > target) {
                locy--;
            } else {
                locx++;
            }
        }

        return false;
    }

}

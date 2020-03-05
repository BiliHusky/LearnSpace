package com.yjw.interview.alg.leetcode;

/**
 * @author David Yang
 * @date 2020-02-22 20:39
 */
public class offer29 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printMatrix(matrix);
        System.out.println();

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] spiralOrder(int[][] matrix) {
        return null;
    }


}

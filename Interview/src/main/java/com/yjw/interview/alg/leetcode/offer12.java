package com.yjw.interview.alg.leetcode;

/**
 * @author David Yang
 * @date 2020-02-22 15:27
 */
public class offer12 {
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty())
            return false;

        for (int i = 0; i < board.length; i++) {
            boolean[][] visit = new boolean[board.length][board[0].length];
            for (int j=0; j< board[0].length; j++) {
                if (dfs(board, visit, word.toCharArray(), 0, i, j))
                     return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, boolean[][]visit, char[] words, int wordLoc, int locx, int locy) {

        if (locx < 0 || locx >= board.length || locy < 0 || locy >= board[0].length)
            return false;

        if (wordLoc >= words.length)
            return false;

        if (!visit[locx][locy] && board[locx][locy] == words[wordLoc]) {
            if (wordLoc == words.length -1)
                return true;

            visit[locx][locy] = true;
            wordLoc++;

            if ( dfs(board, visit, words, wordLoc, locx, locy-1) ||
                    dfs(board, visit, words, wordLoc, locx, locy+1) ||
                    dfs(board, visit, words, wordLoc, locx-1, locy) ||
                    dfs(board, visit, words, wordLoc, locx + 1, locy) )
                return true;
            else {
                visit[locx][locy] = false;
                return false;
            }

        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCCD";
//        char[][] board = {{'A', 'B'}};
//        String word = "BA";
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAABC";
        System.out.println(exist(board, word));
    }
}

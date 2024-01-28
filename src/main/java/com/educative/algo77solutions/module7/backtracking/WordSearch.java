package com.educative.algo77solutions.module7.backtracking;

public class WordSearch {
    public static boolean wordSearch(char[][] grid, String word) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (dfs(grid, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] grid, int r, int c, int index, String word) {
        if (index == word.length())
            return true;
        if (grid[r][c] == word.charAt(index)) {
            int[][] offsets = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int[] offset : offsets) {
                int row = offset[0] + r;
                int col = offset[1] + c;
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
                    if (dfs(grid, row, col, index + 1, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //[['N','W','L','I','M'],
        // ['V','I','L','Q','O'],
        // ['O','L','A','T','O'],
        // ['R','T','A','I','N'],
        // ['O','I','T','N','C']]
        System.out.println(wordSearch(new char[][]{
                {'N', 'W', 'L', 'I', 'M'},
                {'V', 'I', 'L', 'Q', 'O'},
                {'O', 'L', 'A', 'T', 'O'},
                {'R', 'T', 'A', 'I', 'N'},
                {'O', 'I', 'T', 'N', 'C'}
        }, "LATIN"));

    }
}

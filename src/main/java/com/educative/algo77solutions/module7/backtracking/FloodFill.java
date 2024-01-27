package com.educative.algo77solutions.module7.backtracking;

import java.util.Arrays;

public class FloodFill {
    public static int[][] floodFill(int[][] grid, int sr, int sc, int target) {
        if (grid[sr][sc] == target)
            return grid;
        int initialValue = grid[sr][sc];
        grid[sr][sc] = target;
        floodFill(grid, sr, sc, target, initialValue);
        return grid;
    }

    public static void floodFill(int[][] grid, int row, int column, int target, int initialValue) {
        int[][] offsets = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


        for (int[] offset : offsets) {
            int i = offset[0] + row;
            int j = offset[1] + column;
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == initialValue) {
                grid[i][j] = target;
                floodFill(grid, i, j, target, initialValue);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(
                floodFill(new int[][]{
                        new int[]{1, 1, 0, 1},
                        new int[]{0, 0, 0, 0},
                        new int[]{0, 0, 0, 1},
                        new int[]{1, 1, 1, 1}
                }, 2, 3, 2)
        ));
    }
}


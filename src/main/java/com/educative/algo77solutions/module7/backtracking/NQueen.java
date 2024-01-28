package com.educative.algo77solutions.module7.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueen {
    static int solveNQueens(int n) {
        ArrayList<int[]> results = new ArrayList<int[]>();
        int[] solution = new int[n];
        Arrays.fill(solution, -1);
        solveNQueensRecursive(n, solution, results, 0);
        return results.size();
    }

    static void solveNQueensRecursive(int n, int[] solution, ArrayList<int[]> results, int row) {
        if (row == n) {
            results.add(solution);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValidMove(row, i, solution)) {
                solution[row] = i;
                solveNQueensRecursive(n, solution, results, row + 1);
            }
        }
    }

    private static boolean isValidMove(int row, int column, int[] solution) {
        int oldRow, oldColumn, diagonalOffset;
        for (int i = 0; i < row; i++) {
            oldRow = i;
            oldColumn = solution[i];
            diagonalOffset = row - oldRow;
            if (column == oldColumn || oldColumn == column + diagonalOffset || oldColumn == column - diagonalOffset) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(8));
    }
}

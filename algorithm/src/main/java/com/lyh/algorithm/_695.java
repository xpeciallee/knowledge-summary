package com.lyh.algorithm;

import javafx.util.Pair;

import java.util.Stack;

public class _695 {
    int res = 0;

    public int maxAreaOfIsland_stack(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Stack<Pair<Integer, Integer>> stack = new Stack<>();
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    stack.push(new Pair<>(i, j));
                    while (!stack.isEmpty()) {
                        Pair<Integer, Integer> cur = stack.pop();
                        int lastRow = cur.getKey() - 1, nextRow = cur.getKey() + 1;
                        int nextCol = cur.getValue() + 1, lastCol = cur.getValue() - 1;
                        dfs_stack(lastRow, cur.getValue(), stack, grid);
                        dfs_stack(nextCol, cur.getValue(), stack, grid);
                        dfs_stack(cur.getKey(), nextCol, stack, grid);
                        dfs_stack(cur.getKey(), lastCol, stack, grid);
                    }
                    area = Math.max(res, area);
                }
            }

        }

        return area;
    }

    private void dfs_stack(int row, int col, Stack<Pair<Integer, Integer>> stack, int[][] grid) {
        if (row >= 0 && col >= 0 && grid[row][col] == 1 && row < grid.length - 1 && col < grid[row].length) {
            stack.push(new Pair<>(row, col));
            grid[row][col] = 0;
            res++;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(dfs(i, j, grid), max);
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        count += dfs(i - 1, j, grid);
        count += dfs(i + 1, j, grid);
        count += dfs(i, j + 1, grid);
        count += dfs(i, j - 1, grid);
        return count;
    }
}

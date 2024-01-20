package com.educative.algo77solutions.module9.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathsInMaze {
    public static int numberOfPaths(int n, int[][] corridors) {
        int cycles = 0;
        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        for (int[] corridor : corridors) {
            neighbors.computeIfAbsent(corridor[0], k-> new HashSet<>()).add(corridor[1]);
            neighbors.computeIfAbsent(corridor[1], k-> new HashSet<>()).add(corridor[0]);
            cycles += neighbors.get(corridor[0]).stream().filter(neighbors.get(corridor[1])::contains).count();
        }

        return cycles;
    }

    //[1,2],[5,2],[4,1],[2,4],[3,1],[3,4]
    public static void main(String[] args) {
        System.out.println(
                numberOfPaths(5, new int[][]{
                        new int[]{1, 2},
                        new int[]{5, 2},
                        new int[]{4, 1},
                        new int[]{2, 4},
                        new int[]{3, 1},
                        new int[]{3, 4},
                })
        );
    }
}

package com.educative.algo77solutions.module9.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k) {
        // construct adjacency list
        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();
        for (int[] time : times) {
            int source = time[0];
            int target = time[1];
            int delay = time[2];

            adjacencyList.computeIfAbsent(source, key -> new ArrayList<>()).add(new int[]{target, delay});
        }

        int delay = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(t -> t[1]));
        queue.offer(new int[]{k, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (visited.contains(current[0]))
                continue;

            delay = Math.max(delay, current[1]);
            visited.add(current[0]);
            for (int[] neighbor : adjacencyList.getOrDefault(current[0], new ArrayList<>())) {
                queue.offer(new int[]{neighbor[0], current[1] + neighbor[1]});
            }
        }

        if (visited.size() == n)
            return delay;
        return -1;
    }

    //[[1, 2, 5], [1, 3, 10], [1, 4, 15]] , 4 , 1
    public static void main(String[] args) {
        System.out.println(
                networkDelayTime(new int[][]{
                        new int[]{1, 2, 5},
                        new int[]{1, 3, 10},
                        new int[]{1, 4, 15}
                }, 4, 1)
        );
    }
}

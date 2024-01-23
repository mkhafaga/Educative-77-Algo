package com.educative.algo77solutions.module9.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BusRoutes {
    public static int minimumBuses(int[][] busRoutes, int src, int dest) {
        Map<Integer, Set<Integer>> stationToBus = new HashMap<>();
        for (int i = 0; i < busRoutes.length; i++) {
            for (int station : busRoutes[i]) {
                stationToBus.computeIfAbsent(station, key -> new HashSet<>()).add(i);
            }
        }

        int bussesTaken = 0;
        Set<Integer> usedBusses = new HashSet<>();
        Deque<int[]> stations = new ArrayDeque<>();
        stations.add(new int[]{src, bussesTaken});
        while (!stations.isEmpty()) {
            int[] currentStation = stations.poll();
            bussesTaken = currentStation[1];
            if (currentStation[0] == dest)
                return currentStation[1];
            Set<Integer> currentStationBusses = stationToBus.get(currentStation[0]);
            for (int bus : currentStationBusses) {
                if (!usedBusses.contains(bus)) {
                    for (int station : busRoutes[bus]) {
                        stations.add(new int[]{station, bussesTaken + 1});
                    }
                    usedBusses.add(bus);
                }
            }
        }
        return -1;
    }

    //[[1, 9, 7, 8], [3, 6, 7], [4, 9], [8, 2, 3, 7], [2, 4, 5]] , 1 , 5
    public static void main(String[] args) {
        System.out.println(
                minimumBuses(
                        new int[][]{
                                new int[]{1, 9, 7, 8},
                                new int[]{3, 6, 7},
                                new int[]{4, 9},
                                new int[]{8, 2, 3, 7},
                                new int[]{2, 4, 5}
                        },
                        1, 5
                )
        );
    }
}

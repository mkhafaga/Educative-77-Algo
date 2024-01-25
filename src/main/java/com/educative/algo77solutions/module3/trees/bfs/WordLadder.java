package com.educative.algo77solutions.module3.trees.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static int wordLadder(String src, String dest, List<String> words) {
        Set<String> set = new HashSet<String>();
        set.addAll(words);
        if (!set.contains(dest))
            return 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(src);
        int count = 0;
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(dest)){
                return count;
            }
            count++;
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String word = it.next();
                if (differByOne(current, word)) {
                    queue.offer(word);
                    it.remove();
                }
            }
        }

        return 0;
    }

    private static boolean differByOne(String src, String dest) {
        if (src.length() != dest.length())
            return false;

        int count = 0;
        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) != dest.charAt(i))
                count++;

            if (count > 1)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(
//            wordLadder("hit", "cog", List.of("hot", "dot", "lot", "log", "cog"))
                wordLadder("dog", "cat", List.of("hog", "dot", "pot", "pop", "mop", "map", "cap", "cat"))
        );
    }
}

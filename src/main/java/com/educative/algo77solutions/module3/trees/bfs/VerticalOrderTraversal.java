package com.educative.algo77solutions.module3.trees.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderTraversal {

    public static List<List<Integer>> verticalOrder(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> columnToList = new HashMap<>();
        int minIndex = 0;
        int maxIndex = 0;
        columnToList.computeIfAbsent(0, k -> new ArrayList<>()).add(root.data);
        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{root, Integer.valueOf(0)});
        while (!queue.isEmpty()) {
            Object[] current = queue.poll();
            int index = (Integer) current[1];
            TreeNode<Integer> left = ((TreeNode<Integer>) current[0]).left;
            TreeNode<Integer> right = ((TreeNode<Integer>) current[0]).right;

            if (left != null && left.data != null) {
                queue.add(new Object[]{left, index - 1});
                columnToList.computeIfAbsent(index - 1, k -> new ArrayList<>()).add(left.data);
                if (index - 1 < minIndex) {
                    minIndex = index - 1;
                }
            }

            if (right != null && right.data != null) {
                queue.add(new Object[]{right, index + 1});
                columnToList.computeIfAbsent(index + 1, k -> new ArrayList<>()).add(right.data);
                if (index + 1 > maxIndex) {
                    maxIndex = index + 1;
                }
            }
        }

        for (int i = minIndex; i <= maxIndex; i++) {
            result.add(columnToList.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(
                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(300), new TreeNode<Integer>(10), new TreeNode<Integer>(350), new TreeNode<Integer>(15))
        );

        System.out.println(
                verticalOrder(tree.root)
        );
    }
}

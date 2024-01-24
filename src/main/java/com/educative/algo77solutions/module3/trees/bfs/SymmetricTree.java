package com.educative.algo77solutions.module3.trees.bfs;

import com.educative.algo77solutions.module3.trees.bfs.TreeNode;
import com.educative.algo77solutions.module3.trees.dfs.BinaryTreeDiameter;
import com.sun.source.tree.Tree;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode<Integer> left = queue.poll();
            TreeNode<Integer> right = queue.poll();
            if (left == null && right == null)
                continue;

            if (left == null || right == null)
                return false;

            if (left.data != right.data)
                return false;

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSymmetric(
                new BinaryTree<>(
                        Arrays.asList(new TreeNode <Integer> (1), new TreeNode <Integer> (2), new TreeNode <Integer> (2), new TreeNode <Integer> (3), new TreeNode <Integer> (4), new TreeNode <Integer> (4), new TreeNode <Integer> (3))
                ).root
        ));
    }
}

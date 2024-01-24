package com.educative.algo77solutions.module3.trees.dfs;

import java.util.Arrays;

public class BinaryTreeMaxSumPath {

    private static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode<Integer> root) {
        return Math.max(maxPathSumRec(root), maxSum);
    }

    public static int maxPathSumRec(TreeNode<Integer> current) {
        if (current == null)
            return 0;

        int leftPathMax = Math.max(maxPathSumRec(current.left), 0);
        int rightPathMax = Math.max(maxPathSumRec(current.right), 0);

        maxSum = Math.max(maxSum, current.data + leftPathMax + rightPathMax);

        return current.data + Math.max(leftPathMax, rightPathMax);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(
                Arrays.asList(new TreeNode<Integer>(7), new TreeNode<Integer>(3), new TreeNode<Integer>(4),
                        new TreeNode<Integer>(-1), new TreeNode<Integer>(-3))
//                Arrays.asList(new TreeNode<Integer>(-8), new TreeNode<Integer>(2), new TreeNode<Integer>(17),
//                        new TreeNode<Integer>(1), new TreeNode<Integer>(4), new TreeNode<Integer>(19),
//                        new TreeNode<Integer>(5))
        );

        System.out.println(maxPathSum(tree.root));

    }
}

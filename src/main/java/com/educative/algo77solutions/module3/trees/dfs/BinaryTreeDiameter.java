package com.educative.algo77solutions.module3.trees.dfs;

public class BinaryTreeDiameter {
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        return postOrder(root)[0];
    }

    public static int[] postOrder(TreeNode<Integer> current) {
        if (current == null)
            return new int[]{0, 0};


        int[] leftDiameterHeightPair = postOrder(current.left);
        int[] rightDiameterHeightPair = postOrder(current.right);

        int height = Math.max(leftDiameterHeightPair[1], rightDiameterHeightPair[1]) + 1;

        int diameter = Math.max(leftDiameterHeightPair[0], Math.max(rightDiameterHeightPair[0],
                leftDiameterHeightPair[1] + rightDiameterHeightPair[1]));
        return new int[]{diameter, height};
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);

        root.right = new TreeNode<>(3);
        root.right.left = new TreeNode<>(6);
        System.out.println(diameterOfBinaryTree(root));
    }
}

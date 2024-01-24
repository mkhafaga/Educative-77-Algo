package com.educative.algo77solutions.module3.trees.bfs;

import com.educative.algo77solutions.module3.trees.bfs.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTree<T> {
    com.educative.algo77solutions.module3.trees.bfs.TreeNode<T> root;

    BinaryTree(List<com.educative.algo77solutions.module3.trees.bfs.TreeNode<T>> ListOfNodes) {
        root = createBinaryTree(ListOfNodes);
    }

    private com.educative.algo77solutions.module3.trees.bfs.TreeNode<T> createBinaryTree(List<com.educative.algo77solutions.module3.trees.bfs.TreeNode<T>> ListOfNodes) {
        if (ListOfNodes.isEmpty()) {
            return null;
        }

        // Create the root node of the binary tree
        com.educative.algo77solutions.module3.trees.bfs.TreeNode<T>
                root = new com.educative.algo77solutions.module3.trees.bfs.TreeNode<>(ListOfNodes.get(0).data);

        // Create a queue and add the root node to it
        Queue<com.educative.algo77solutions.module3.trees.bfs.TreeNode<T>> q = new LinkedList<>();
        q.add(root);

        // Start iterating over the list of ListOfNodes starting from the second node
        int i = 1;
        while (i < ListOfNodes.size()) {
            // Get the next node from the queue
            com.educative.algo77solutions.module3.trees.bfs.TreeNode<T> curr = q.remove();

            // If the node is not null, create a new TreeNode object for its left child,
            // set it as the left child of the current node, and add it to the queue
            if (ListOfNodes.get(i) != null) {
                curr.left = new com.educative.algo77solutions.module3.trees.bfs.TreeNode<>(ListOfNodes.get(i).data);
                q.add(curr.left);
            }

            i++;

            // If there are more ListOfNodes in the list and the next node is not null,
            // create a new TreeNode object for its right child, set it as the right child
            // of the current node, and add it to the queue
            if (i < ListOfNodes.size() && ListOfNodes.get(i) != null) {
                curr.right = new TreeNode<>(ListOfNodes.get(i).data);
                q.add(curr.right);
            }

            i++;
        }

        // Return the root of the binary tree
        return root;
    }
}

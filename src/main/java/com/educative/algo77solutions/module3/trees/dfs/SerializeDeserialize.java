package com.educative.algo77solutions.module3.trees.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SerializeDeserialize {
    public static List<String> serialize(TreeNode<Integer> root) {
        return serializeRec(root, new ArrayList<>());
    }

    public static List<String> serializeRec(TreeNode<Integer> current, List<String> tree) {
        if (current == null) {
            tree.add(null);
            return tree;
        }

        tree.add(current.data.toString());
        serializeRec(current.left, tree);
        serializeRec(current.right, tree);

        return tree;
    }

    public static TreeNode<Integer> deserialize(List<String> stream) {
        Collections.reverse(stream);
        return deserializeRec(stream);
    }

    public static TreeNode<Integer> deserializeRec(List<String> stream) {
        String current = stream.remove(stream.size() - 1);
        if (current == null)
            return null;

        TreeNode<Integer> node = new TreeNode<>(Integer.parseInt(current));
        node.left = deserializeRec(stream);
        node.right = deserializeRec(stream);
        return node;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(
                Arrays.asList( new TreeNode<Integer>(1), null, new TreeNode<Integer>(2), null, new TreeNode<Integer>(3), null, new TreeNode<Integer>(4), null, new TreeNode<Integer>(5))
        );

        List<String> serializedTree = serialize(tree.root);
        System.out.println(serializedTree);

        deserialize(serializedTree);

    }
}

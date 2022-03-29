package com.zl.tree.bt;

import com.zl.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreTree {

    public static void main(String[] args) {
        TreeNode subLeft = new TreeNode(1);
        TreeNode subRight = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        left.left = subLeft;
        left.right = subRight;
        TreeNode right = new TreeNode(5);

        TreeNode root = new TreeNode(4);
        root.left = left;
        root.right = right;
        List<Integer> integers = preTree(root);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }

    public static List<Integer> preTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            res.add(null);
            return res;
        }
        res.add(root.val);
        List<Integer> left = preTree(root.left);
        List<Integer> right = preTree(root.right);
        res.addAll(left);
        res.addAll(right);
        return res;
    }
}

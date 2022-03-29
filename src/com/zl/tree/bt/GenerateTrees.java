package com.zl.tree.bt;

import com.zl.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */
public class GenerateTrees {

    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(3);
        List<List<Integer>> list = new ArrayList<>();
        System.out.println();

    }

    public static List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return buildTree(1, n);
    }

    public static List<TreeNode> buildTree(int i, int n) {
        List<TreeNode> res = new ArrayList<>();
        if (i > n) {
            res.add(null);
            return res;
        }
        //循环根节点
        for (int j = i; j < n; j++) {
            //根节点为j，计算左右子树的可能性
            //小于j的都在左子树
            List<TreeNode> leftTreeNodes = buildTree(i, j - 1);
            //大于j的都在右子树
            List<TreeNode> rightTreeNodes = buildTree(j + 1, n);

            //所有可能性left * right
            for (TreeNode left : leftTreeNodes
            ) {
                for (TreeNode right : rightTreeNodes
                ) {
                    TreeNode root = new TreeNode(j);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }

        }
        return res;
    }

}

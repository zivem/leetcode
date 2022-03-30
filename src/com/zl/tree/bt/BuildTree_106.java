package com.zl.tree.bt;

import com.zl.base.TreeNode;

/**
 * @link https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * use inorder and postorder
 * @date 2022.03.30
 */
public class BuildTree_106 {
    public static void main(String[] args) {

        int[] postorder = new int[]{9,15,7,20,3};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = buildTree( inorder, postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }

        int pageSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, inStart, index - 1, postorder, postStart, postStart + pageSize);
        root.right = buildTree(inorder, index + 1, inEnd, postorder, postStart + pageSize + 1, postEnd - 1);
        return root;
    }
}

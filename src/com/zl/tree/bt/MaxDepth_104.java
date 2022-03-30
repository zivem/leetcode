package com.zl.tree.bt;

import com.zl.base.TreeNode;

/**
 * @link https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @date 2022.03.30
 */
public class MaxDepth_104 {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        return sumDepth(root);
    }

    public int sumDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = sumDepth(root.left);
        int right = sumDepth(root.right);
        return 1 + Math.max(left ,right);
    }

}

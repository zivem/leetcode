package com.zl.tree.bt;

import com.zl.base.TreeNode;

/**
 * @link https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @date 2022.03.29
 */
public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        //左子树限定最大值，右子树限定最小值
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}

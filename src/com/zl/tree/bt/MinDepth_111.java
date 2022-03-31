package com.zl.tree.bt;

import com.zl.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @link https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @date 2022.03.30
 */
public class MinDepth_111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            //size在变，所以需要变量接收!!!
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            depth++;
        }

        return depth;
    }

}

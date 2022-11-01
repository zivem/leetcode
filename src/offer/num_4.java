package offer;

import com.zl.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回根结点
 */
public class num_4 {

    public static void main(String[] args) {
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};
        System.out.println(buildTree(preorder, inorder).val);
    }
    static Map<Integer,Integer> midMap = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }

        //映射，快速查找
        for (int i = 0; i < inorder.length; i++) {
            midMap.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length -1, 0, inorder.length -1);
    }

    public static TreeNode dfs(int[] preorder, int[] inorder, int pl, int pr, int il, int ir){
        if(pl > pr){
            return null;
        }
        int k = midMap.get(preorder[pl]) -il;
        TreeNode treeNode = new TreeNode(preorder[pl]);
        treeNode.left = dfs(preorder, inorder, pl + 1, pl + k, il, il + k - 1);
        treeNode.left = dfs(preorder, inorder, pl + k + 1, pr, il + k + 1, ir);
        return treeNode;
    }

}

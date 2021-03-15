
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    //根据前序遍历我们可以知道根节点为3
    //再根据中序遍历知道了左子树为9，右子树为15,20,7
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(getList(preorder), getList(inorder));
    }

    public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0) {
            return null;
        }
        if (preorder.size() == 1) {
            return new TreeNode(preorder.get(0));
        }
        //获得根节点的值
        int rootVal = preorder.get(0);
        TreeNode root = new TreeNode(rootVal);

        //中序遍历中根节点的下标,index也是左边的个数
        int index = inorder.indexOf(rootVal);

        //去建立左子树
        TreeNode left = buildTree(preorder.subList(1, 1 + index), inorder.subList(0, index));
        //去建立右子树
        TreeNode right = buildTree(preorder.subList(1 + index, preorder.size()), inorder.subList(index + 1, inorder.size()));
        root.left = left;
        root.right = right;

        return root;
    }

    public List<Integer> getList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int e : arr) {
            list.add(e);
        }
        return list;
    }

}
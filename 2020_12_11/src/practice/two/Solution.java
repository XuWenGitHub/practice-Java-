package practice.two;




class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        //交换两个节点
        TreeNode l = root.left;
        root.left = root.right;
        root.right = l;
        //递归去处理左子树和右子树
        Mirror(root.left);
        Mirror(root.right);
    }
}

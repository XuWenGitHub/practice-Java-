package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/15 23:23
 * Introduce:
 */
public class Demo {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(diameterOfBinaryTree(root));
    }


    //左子树中高度+右子树高度即可
    //注意！！！不一定二叉树的最大直径一定经过根节点，也可能是从其他节点开始的
    //所以我们要以二叉树的每一个节点为根节点去找其左子树和右子树高度和
    private static int dameter;
    public static int diameterOfBinaryTree(TreeNode root) {
        dameter = 0;
        height(root);
        return dameter;
    }
    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        dameter = Math.max(dameter,(left+right));
        return 1+Math.max(left,right);
    }
}

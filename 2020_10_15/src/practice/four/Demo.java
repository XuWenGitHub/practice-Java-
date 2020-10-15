package practice.four;

import java.util.Random;

/**
 * @PackgeName: practice.four
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/15 21:50
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
//        Random r = new Random();
//        int num = r.nextInt(10);
//        System.out.println(num);


    }
    //求和路径
    private int res;
    public int pathSum(TreeNode root, int sum) {
        res = 0;
        preOrder(root,sum);
        return res;
    }
    //深度优先查找
    public void dfs(TreeNode root,int sum){
        if(root==null){
            return;
        }
        if(root.val==sum){
            res++;
        }
        dfs(root.left,sum-root.val);
        dfs(root.right,sum-root.val);
    }
    //因为我们可以以任何一个节点为根，所有每个节点去深度优先查找一次
    public void preOrder(TreeNode root,int sum){
        if(root==null){
            return;
        }
        dfs(root,sum);
        preOrder(root.left,sum);
        preOrder(root.right,sum);
    }
    


    //判断一棵树是否是二叉搜索树
    //二叉搜索树的中序遍历时递增的，然后定义一个prev，然后每次比较即可
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean left = isValidBST(root.left);
        if(prev!=null&&root.val<=prev.val){
            return false;
        }
        prev = root;
        boolean right = isValidBST(root.right);
        return left&&right;
    }
}

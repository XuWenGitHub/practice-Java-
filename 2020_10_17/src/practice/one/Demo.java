package practice.one;

import java.util.LinkedList;
import java.util.List;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/16 22:35
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
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.right = node5;
        System.out.println(binaryTreePaths(root));
    }



    //求二叉树的坡度
    int res = 0;    //最后返回的结果
    public int findTilt(TreeNode root) {
        preOrder(root); //直接去前序遍历即可
        return res;
    }
    //前序遍历，计算树的节点和,顺便统计每次左子树和右子树和差的绝对值
    public int preOrder(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = preOrder(root.left); //计算左子树之和
        int right = preOrder(root.right);   //计算右子树之和
        res+=Math.abs(left-right);
        return root.val+left+right;
    }


    //二叉树的所有路径
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        getPath(root,res,new StringBuilder());
        return res;
    }
    //sb每次保存上一次的
    public static void getPath(TreeNode root,List<String> res,StringBuilder sb){
        if(root==null){
            return;
        }
        StringBuilder sb2 = new StringBuilder(sb);  //这里一定要用一个新的，起到了回溯的作用
        if(root.left==null&&root.right==null){
            sb2.append(root.val);
            res.add(sb2.toString());
            return;
        }
        sb2.append(root.val).append("->");
        getPath(root.left,res,sb2);
        getPath(root.right,res,sb2);
    }

    //判断一个数是否为平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)<=1&&isBalanced(root.left)&&isBalanced(root.right)){
            return true;
        }
        return false;
    }
    //求以root节点为根节点的数高度
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = height(root.left)+1;
        int right = height(root.right)+1;
        return Math.max(left,right);
    }
}

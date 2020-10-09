package practice.one;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/9 0:03
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    //判断一个二叉树是否是单值二叉树
    //如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
    //只有给定的树是单值二叉树时，才返回 true；否则返回 false
    //通过深度优先遍历中后序遍历，即可解决
    public boolean isUnivalTree(TreeNode root) {
        boolean flag = true;
        if(root==null){
            return true;
        }
        //后序遍历
        flag = isUnivalTree(root.left); //左递归
        flag &= isUnivalTree(root.right);    //右递归
        //现在递归到最深处了，现在往回倒退
        if((root.left!=null&&root.left.val!=root.val)||(root.right!=null&&root.right.val!=root.val)){
            flag = false;
        }
        return flag;
    }
}

package practice.three;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/8 22:40
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    //计算给定二叉树的所有左叶子之和。
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        return sumOfLeftLeaves(root.left,true)+sumOfLeftLeaves(root.right,false);
    }
    //root代表树，flag代表从左子树还是右子树
    public int sumOfLeftLeaves(TreeNode root,boolean flag){
        //空树
        if(root==null){
            return 0;
        }else{
            //只有一个节点的树,并且是右子节点
            if(root.left==null&&root.right==null&&flag){
                return root.val;
            }
            //左子树中叶子结点值+右子树中叶子结点值+根节点
            int leftLeafNode = sumOfLeftLeaves(root.left,true);
            int rightLeafNode = sumOfLeftLeaves(root.right,false);
            return leftLeafNode+rightLeafNode;
        }
    }
}

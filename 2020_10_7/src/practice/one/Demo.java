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
 * Date: 2020/10/7 14:10
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    //反转一颗二叉树
    //root看成树，分成：
    //(1)空树   （2）不是空树：根节点，左子树，右子树
    public TreeNode invertTree(TreeNode root) {
        //空树
        if(root==null){
            return null;
        }
        //不是空树，分成根节点左子树右子树
        TreeNode res = new TreeNode(root.val);
        //遍历root的左子树,变成r的右子树
        TreeNode resRight = invertTree(root.left);
        res.right = resRight;
        //遍历root的右子树，变成r的左子树
        TreeNode resLeft = invertTree(root.right);
        res.left = resLeft;
        return res; //返回新的二叉树
    }

    //二叉搜索树的最小绝对值差
    int min = Integer.MAX_VALUE;    //保存两节点的差的绝对值的最小值
    TreeNode pre = null;    //保存中序遍历中，遍历的当前节点的前驱节点
    public int getMinimumDifference(TreeNode root) {
        preOrder(root);
        return min;
    }
    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        preOrder(root.left);
        if(pre!=null){
            min = Math.min(root.val-pre.val,min);
        }
        pre = root; //更新前驱
        preOrder(root.right);
    }
}

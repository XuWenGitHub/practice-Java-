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
 * Date: 2020/9/27 10:47
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    //判断一颗二叉树是否对称
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isTrue(root.left,root.right);
    }

    /*
    把左子树右子树传来,递归判断是否对称
    */
    public boolean isTrue(TreeNode l,TreeNode r){
        if(l==null&&r==null){   //如果两个都为空了，说明true
            return true;
        }
        if(l==null||r==null||l.val!=r.val){ //如果其中一个为空，或者值不同，那说明不对称
            return false;
        }
        //返回左子树的左边和右子树的右边&&左子树的右边和右子树的左边
        return isTrue(l.left,r.right)&&isTrue(l.right,r.left);
    }
}

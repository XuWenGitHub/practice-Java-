package practice.two;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/28 11:22
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    //给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    //把一颗树分为跟节点，左子树，右子树
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){ //如果是空树，那么一定不满足
            return false;
        }else{  //当前树不是空树
            if(root.left==null&&root.right==null){  //如果该树只有一个节点，判断是否和sum相等
                return root.val==sum;
            }else{  //其他情况
                //那说明该树 = 根节点，左子树，右子树
                //我们便去在左子树和右子树中找，(sum-跟节点.val)
                boolean isHas = hasPathSum(root.left,sum-root.val);
                if(isHas==false){
                    isHas = hasPathSum(root.right,sum-root.val);
                }
                return isHas;
            }
        }
    }
}

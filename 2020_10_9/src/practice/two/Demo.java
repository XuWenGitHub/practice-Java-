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
 * Date: 2020/10/9 16:05
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        int x=10;
        while(x-->0){
            System.out.println(x);

        }
    }
    /*
    修剪二叉搜索树，给定最小边界L和最大边界R，让所有节点的值再[L,R]中
    1.当root.val<low,舍弃左子树和根节点，返回右子树去修建
    2.当root.val>high,舍弃右子树和根节点，返回左子树去修建
    3.当low<=root.val<=high 说明根节点符合，然后去裁剪一下左子树和右子树然后返回
    */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null){ //空树
            return null;
        }
        if(root.val<low){   //根节点值小于最小边界，那么去掉根节点和左子树去裁剪右子树
            return trimBST(root.right,low,high);
        }
        if(root.val>high){  //根节点大于最大边界，那么去掉根节点和右子树去剪裁左子树
            return trimBST(root.left,low,high);
        }
        //根节点值>最小边界&&<最大边界，那么去剪裁左子树和右子树，然后返回根节点
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }
}

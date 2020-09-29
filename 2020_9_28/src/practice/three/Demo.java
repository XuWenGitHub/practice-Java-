package practice.three;



import java.util.Deque;
import java.util.LinkedList;

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
 * Date: 2020/9/28 11:31
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(1);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(Integer.parseInt("100",2));
        System.out.println();
        String s = String.valueOf(root.val);
        System.out.println(s);
        char c = (char)1;
        System.out.println(c);
        int a = '1'+0;
        int b = '0'+1;
        System.out.println(a+" "+b);
    }
    //从根到叶的二进制数之和
    public int sumRootToLeaf(TreeNode root) {
        if(root==null){
            return 0;
        }
        res = 0;
        toBinaryString(new StringBuilder(),root,(char)(root.val+'0'));
        return res;
    }
    static int res;
    public void toBinaryString(StringBuilder sb,TreeNode root,char a){
        StringBuilder newSb = new StringBuilder(sb);
        newSb.append(a);
        if(root==null){ //空树
            return;
        }else{
            if(root.left==null&&root.right==null){  //只有一个节点的树
                //当前newSb中就是"1001"....
                res+=Integer.parseInt(newSb.toString(),2);
            }else{
                if(root.left!=null){    //左子树递归
                    toBinaryString(newSb,root.left,(char)(root.left.val+'0'));
                }
                if(root.right!=null){
                    toBinaryString(newSb,root.right,(char)(root.right.val+'0'));
                }
            }
        }
    }
}

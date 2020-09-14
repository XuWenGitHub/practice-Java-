package practice.four;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @PackgeName: practice.four
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/13 14:51
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        List<ArrayList<Integer>> lists = new ArrayList<>();

    }
    //从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        List<TreeNode> lists = new ArrayList<>();   //保存每一层的节点
        lists.add(root);
        while(!lists.isEmpty()){
            List<Integer> num = new ArrayList<>();  //保存当前这层的值
            List<TreeNode> nodes = new ArrayList<>();   //保存当前这一层的下一层节点
            for(TreeNode node:lists){       //遍历当前层的节点
                num.add(node.val);  //遍历这一层的节点，保存这一层的值
                //遍历这一层的节点，保存下一层的节点
                if(node.left!=null){
                    nodes.add(node.left);
                }
                if(node.right!=null){
                    nodes.add(node.right);
                }
            }
            res.add(num);
            lists = nodes;
        }
        return res;
    }
}
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}

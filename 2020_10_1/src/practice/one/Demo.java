package practice.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 * Date: 2020/10/1 15:38
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    //合并二叉树,把两颗二叉树合并成一个二叉树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //两棵树都为空树
        if(t1==null&&t2==null){
            return null;
        }
        //其中一颗树为空书
        if(t1==null||t2==null){
            return t1==null?t2:t1;
        }
        //现在都不为空树，先处理根节点
        TreeNode root =new TreeNode(t1.val+t2.val);
        //处理root左子树
        TreeNode leftNode = mergeTrees(t1.left,t2.left);
        root.left = leftNode;
        //处理root右子树
        TreeNode rightNode = mergeTrees(t1.right,t2.right);
        root.right = rightNode;
        //返回root
        return root;
    }
    //二叉树自底向上的层次遍历
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //保存最后的结果，因为要自底向上的层次遍历结果，所有用链表，头插，时间复杂度为O(1)
        List<List<Integer>> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>(); //来一个队列，来广度优先遍历
        queue.offer(root);  //保存根节点
        while(!queue.isEmpty()){    //如果队列不为空
            List<Integer> inside = new ArrayList<>();   //保存树每一层的元素的值
            int len = queue.size(); //算出当前队列长度，然后for循环，就遍历上一层，保存下一层
            for(int i=0;i<len;i++){ //遍历上一层的元素
                TreeNode node = queue.poll();   //取出每一个node
                inside.add(node.val);   //添加node值
                //queue添加下一层的节点
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            //把inside头插到res
            res.add(0,inside);
        }
        return res;
    }
}

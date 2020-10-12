package practice.two;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/12 17:55
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

    }
    //合并二叉树,把两颗二叉树合并成一个二叉树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //两棵树都为空
        if(t1==null&&t2==null){
            return null;
        }
        //其中一颗树为空，另一棵树不为空
        if(t1==null||t2==null){
            return t1==null?t2:t1;
        }
        //都不为空
        TreeNode root = new TreeNode(t1.val+t2.val);
        root.left = mergeTrees(t1.left,t2.left);
        root.right = mergeTrees(t1.right,t2.right);
        return root;
    }


    TreeNode head = null;   //存第一个
    TreeNode last = null;
    //把一个二叉搜索树变成一个单链表
    //用中序遍历dfs，然后每次保存当前遍历的节点记录到last
    //如果last不为null，就让last指向现在遍历的这个，然后last.left置空
    public TreeNode increasingBST(TreeNode root) {
        if(root!=null){
            increasingBST(root.left);   //递归到最左边，找到最小的
            if(head==null){
                head = root;    //单链表的头结点
            }
            if(last!=null){ //上一次遍历的节点
                last.right = root;  //让其指向root
                last.left = null;   //将左子树置空
            }
            last = root;    //更新最后一个节点
            increasingBST(root.right);
        }
        return head;    //返回单链表的头结点
    }

    //判断一颗树是否是完全二叉树
    //带空节点的层序遍历，遇到null，就直接return
    //然后遍历队列中的节点，如果都为null，那说明就是完全二叉树，如果有一个不是那就不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(true){
            TreeNode node = queue.poll();
            if(node==null){
                break;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        while(!queue.isEmpty()){
            if(queue.poll()!=null){
                return false;
            }
        }
        return true;
    }

    //求二叉树的最大宽度
    //根据满二叉树的特性，然后我们把每个节点全存成1,2,3,4,5按层来存
    //然后计算每一层的宽度就是每一层最后一个元素val-每一层第一个元素值+1
    //完全二叉树的特性，根节点的左子树为2*n，根节点的右子树为2*n+1
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>(); //用来层序遍历的队列
        queue.add(root);
        LinkedList<Integer> values = new LinkedList<>();    //用来存每一层的值
        values.add(1);
        int res = 1;    //这是最后返回的结果，如果根节点不为0，第一层的最大宽度就是1
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();   //出队列一个节点
                Integer nodeVal = values.removeFirst(); //取出node的值
                if(node.left!=null){
                    queue.add(node.left);   //存下一层的左子树的节点
                    values.addLast(nodeVal*2);     //存下一层的左子树节点的值
                }
                if(node.right!=null){
                    queue.add(node.right);  //存下一层的右子树的节点
                    values.addLast(nodeVal*2+1);   //存下一层的右子树节点的值
                }
            }
            if(values.size()>=2){    //如果只有一个的话，就没必要去判断，因为根节点的宽度就是1
                res = Math.max(res,values.getLast()-values.getFirst()+1); //最右边的节点的值-这一层最左边的值+1就是这一层的宽度，根据满二叉树的特性
                // res = Math.max(res, values.getLast() - values.getFirst() + 1);
            }
        }
        return res;
    }
}

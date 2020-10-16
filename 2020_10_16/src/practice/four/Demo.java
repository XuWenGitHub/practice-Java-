package practice.four;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @PackgeName: practice.four
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/16 13:47
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
    static class Node{
        int va;
        List<Node> children;

        public Node(int va, List<Node> children) {
            this.va = va;
            this.children = children;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node5;
        node2.left = node3;
        node2.right = node4;
        //flatten(root);
        postOrder(root);
    }


    //给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
    //空树，return 0；
    //不是空树，val<L,去右子树找
    //val>R,去左子树找
    //L<=val<=R,去左子树和右子树找
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null){
            return 0;
        }
        if(root.val<L){
            return rangeSumBST(root.right,L,R);
        }
        if(root.val>R){
            return rangeSumBST(root.left,L,R);
        }
        return root.val+rangeSumBST(root.left,L,R)+rangeSumBST(root.right,L,R);
    }


    //二叉排序树查找某个元素，找到，返回该节点，没找到返回null
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }else if(root.val>val){
            return searchBST(root.left,val);
        }else{
            return searchBST(root.right,val);
        }

    }

    //给定一个有序整数数组，元素各不相同且按升序排列，
    //编写一个算法，创建一棵高度最小的二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    public TreeNode sortedArrayToBST(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        int mid = (right+left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,left,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,right);
        return root;
    }


    //N叉树的最大深度
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        if(root.children.isEmpty()){    //没有孩子，只有根节点
            return 1;
        }
        int res = 0;    //初始化最后返回的结果,这个res还是有回溯的
        for(Node childNode:root.children){
            res = Math.max(res,maxDepth(childNode)+1);
        }
        return res;
    }

    /*
    给定给一个二叉树，原地将它展开为一个单链表
    [1,2,5,3,4,5]->[1,2,3,4,5,6]
    非递归前序遍历
    */
    public static void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode prev=null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        //非递归前序遍历
        while(!stack.isEmpty()||current!=null){
            while(current!=null){
                //处理节点
                if(prev!=null){
                    prev.left = null;   //左子树置空
                    prev.right = current;   //让上一个遍历的节点右子树指向现在current
                }
                prev = current; //更新prev节点

                //把当前节点的右节点压入栈,因为每次处理节点都把右子树改了
                if(current.right!=null){
                    stack.push(current.right);
                }
                current = current.left; //一直先往左走
            }
            TreeNode popNode = stack.poll();    //从栈中弹出来，曾经节点的右子树
            current = popNode;  //去遍历右子树
        }
    }
    //迭代法二叉树的后序遍历
    public static void postOrder(TreeNode root){
        if(root==null){
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        TreeNode last = null;
        while(!stack.isEmpty()||current!=null){
            while (current!=null){
                stack.push(current);
                current = current.left;
            }
            TreeNode top = stack.peek();
            if(top.right==null){    //如果栈顶元素没有右子树，那么可以直接输出，然后pop
                System.out.print(top.val);
                last = top;
                stack.pop();
            }else if(last!=null&&top.right==last){  //判断当前栈顶元素是否是从右子树回来的
                System.out.print(top.val);
                last = top;
                stack.pop();
            }else { //去右子树查找
                current = top.right;
            }
        }
    }
}

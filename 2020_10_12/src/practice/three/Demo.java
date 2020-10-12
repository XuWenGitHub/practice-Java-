package practice.three;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/12 19:30
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
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        new Demo().preOrder(root);
        new Demo().infixOrder(root);
        new Demo().postOrder(root);
    }
    //非递归后序遍历二叉树
    public void postOrder(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        TreeNode last = null;   //遍历每个节点
        while(!stack.isEmpty()||current!=null){
            //先向左一直遍历
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            TreeNode top = stack.peek();
            if(top.right==null){
                System.out.print(top.val+" ");
                stack.pop();
                last = top;
            }else if(top.right==last){
                System.out.print(top.val+" ");
                stack.pop();
                last = top;
            }else{
                current = top.right;
            }
        }
        System.out.println();
    }

    //非递归中序遍历二叉树
    public void infixOrder(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while(!stack.isEmpty()||current!=null){
            while (current!=null){
                stack.push(current);
                current = current.left;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val+" ");
            current = top.right;
        }
        System.out.println();
    }
    //非递归前序遍历二叉树
    public void preOrder(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (!stack.isEmpty()||current!=null){
            //先一直往左走
            while(current!=null){
                System.out.print(current.val+" ");
                stack.push(current);
                current = current.left;
            }
            //栈中取出一个
            TreeNode top = stack.pop();
            current = top.right;    //往右走
        }
        System.out.println();
    }
}

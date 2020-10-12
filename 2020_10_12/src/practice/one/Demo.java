package practice.one;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/12 10:10
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
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        preOrder(root);
        System.out.println();
        infixOrder(root);
        System.out.println();
        postOrder(root);
    }
    //非递归前序遍历
    public static void preOrder(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                System.out.print(root.val+" ");
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            root = top.right;
        }
    }
    //非递归中序遍历
    public static void infixOrder(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while(!stack.isEmpty()||current!=null){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val+" ");
            current = top.right;
        }
    }

    //非递归后序遍历
    //当右子树为空，就可以直接输出中间那个
    //定义一个prev保存每次遍历的上一个元素是哪个，来确定，是否是从右边回来的
    public static void postOrder(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        TreeNode last = null;    //每次遍历保存右子树的节点，每次更新
        while(!stack.isEmpty()||current!=null){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            TreeNode top = stack.peek();
            if(top.right==null){    //说明当前栈顶元素的右子树为空，就可以直接把它弹出，并输出，并更新last
                stack.pop();
                System.out.print(top.val+" ");
                last = top; //把右子树保存到last，每次更新一下，好判断是否知道当前节点是从左子树还是右子树回来的
            }else if(top.right == last){    //可以知道当前元素是从右子树回来的
                System.out.print(top.val+" ");
                stack.pop();
            }else{  //从左子树回来的
                current = top.right;
            }
        }
    }
}

package practice.one;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/15 12:43
 * Introduce:
 */
public class Demo {
    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public static Node addFrist(Node head,int e){
        Node cur = head;
        head = new Node(e);
        head.next = cur;
        return head;
    }
    public static Node addLast(Node head,int e){
        if(head==null){
            return new Node(e);
        }
        Node cur = head;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = new Node(e);
        return head;
    }
    public static Node removeFrist(Node head){
        if(head==null||head.next==null){
            return null;
        }
        head = head.next;
        return head;
    }
    public static Node removeLast(Node head){
        if(head==null||head.next==null){
            return null;
        }
        Node cur = head;
        while(cur.next!=null){
            if(cur.next.next==null){    //说明cur的下一个是最后一个节点
                cur.next = null;    //删除cur的下一个节点
                break;  //退出循环
            }
            cur = cur.next;
        }
        return head;
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = height(root.left)+1;
        int right = height(root.right)+1;
        return Math.max(left,right);
    }
    public void layerTraversal(TreeNode root){
        if(root==null){
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val+" ");
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {

    }
}

package practice.three;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/14 18:49
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int left = height(root.left)+1;
            int right = height(root.right)+1;
            return Math.max(left,right);
        }
    }
    public static void order(TreeNode root){
        if(root==null){
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val+" ");
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {

    }
    public static Node addFrist(Node head,int e){
        Node temp = head;    //不管是不是null，直接保存起来
        head = new Node(e); //头插入
        head.next = temp;    //连接原来的头结点
        return head;    //返回头结点
    }
    public static Node addLast(Node head,int e){
        if(head==null){ //链表为空
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
        if(head==null){
            return null;
        }
        head = head.next;
        return head; //返回的删除的第一个
    }
    public static Node removeLast(Node head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        Node cur = head;
        Node res=null;
        while(cur.next!=null){
            if(cur.next.next==null){
                res = cur.next;
                cur.next = null;
            }
            cur = cur.next;
        }
        return res; //返回删除的最后一个
    }
}

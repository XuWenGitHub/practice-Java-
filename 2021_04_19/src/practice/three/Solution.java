package practice.three;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void list(Node head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        root.next = node2;
        node2.next = node3;

        Node root1 = new Node(1);
        Node node4 = new Node(7);
        root1.next = node4;

        list(add(root, root1));
    }
    /*
    创造两个栈，然后把两个root节点都往栈里面压
    最后算即可
     */
    static Deque<Node> stack1;
    static Deque<Node> stack2;
    public static Node add(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
        dfs(root1,root2);
        Node last = null;
        Node cur = null;
        int temp = 0;   //余数
        while (!stack1.isEmpty()&&!stack2.isEmpty()){
            int addSum = stack1.pop().val+stack2.pop().val+temp;
            if(last==null){
                last = new Node(addSum%10);
                cur = last;
            }else {
                cur = new Node(addSum%10);
                cur.next = last;
                last = cur;
            }
            temp = addSum/10;
        }
        while(!stack1.isEmpty()){
            int addSum = stack1.pop().val+temp;
            cur = new Node(addSum%10);
            cur.next = last;
            last = cur;
            temp = addSum/10;
        }
        while(!stack2.isEmpty()){
            int addSum = stack2.pop().val+temp;
            cur = new Node(addSum%10);
            cur.next = last;
            last = cur;
            temp = addSum/10;
        }
        while(temp!=0){
            int addSum = temp%10;
            cur = new Node(addSum%10);
            cur.next = last;
            last = cur;
            temp = addSum/10;
        }
        return cur;
    }

    public static void dfs(Node root1, Node root2) {
        if(root1==null&&root2==null){
            return;
        }
        if(root1!=null&&root2!=null){
            stack1.push(root1);
            stack2.push(root2);
            dfs(root1.next,root2.next);
        }else if(root1==null){
            stack2.push(root2);
            dfs(null,root2.next);
        }else{
            stack1.push(root1);
            dfs(root1.next,null);
        }
    }
}

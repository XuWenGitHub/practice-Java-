import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    public static void list(){
        for(int i=0;i<res.size();i++){
            if(i==0){
                System.out.print(res.get(i).val);
            }else{
                System.out.print("->"+res.get(i).val);
            }
        }
    }
    static LinkedList<Node> res = new LinkedList<>();
    public static void dfs(Node root,int val){
        if(root==null){ //如果为空，直接返回
            return;
        }
        //走到这里说明root都不为null
        res.addLast(root);  //先把当前节点添加到双向链表的最后一位
        //先判断当前root是否为叶子结点
        if(root.left==null&&root.right==null){
            if(val==root.val){ //最后val如果==root.val，
                //那么说明当前路劲，根节点到叶子结点的路径和为val
                list();
            }
        }
        //当前节点不是叶子结点,递归去处理当前节点的左子树和右子树
        dfs(root.left, val-root.val);
        dfs(root.right, val-root.val);
        res.removeLast();   //删除最后一个，回溯的时候，删除最后一个节点
    }
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        //System.out.println("Hello World!");
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(3);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        dfs(root,7);
        LinkedList<Integer> list = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(list);
    }

}
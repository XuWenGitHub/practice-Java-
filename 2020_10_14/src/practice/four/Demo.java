package practice.four;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


/**
 * @PackgeName: practice.four
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/14 20:04
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
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
//        LinkedList<Integer> res = new LinkedList<>();
//        res.addFirst(1);
//        boolean flag = true;
//        System.out.println(flag);
//        flag = !flag;
//        System.out.println(flag);

        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;

        TreeNode root2 = new TreeNode(4);
        TreeNode root2Left = new TreeNode(8);
        TreeNode root2Right = new TreeNode(9);
        root2.left = root2Left;
        root2.right = root2Right;

        System.out.println(isSubStructure(root,root2));
    }
    //从底向上后续遍历，如果当前元素为0且左右子树为null，则删除节点
    //修建二叉树,从下往上修剪即可
    public TreeNode pruneTree(TreeNode root) {
        if(root==null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val==0&&root.left==null&&root.right==null){
            return null;
        }
        return root;
    }

    //判断B是不是A的子结构
    //在A树中找B节点，用dfs，后序遍历查找,找到后判断两棵树是否一样，如果一样返回true，如果不一样返回false，如果是false，就继续找
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null){
            return false;
        }
        boolean left = isSubStructure(A.left,B);
        boolean right = isSubStructure(A.right,B);
        if(!left&&!right&&A.val==B.val){
            //!left&&!right非常重要，一定要判断，不然如果一棵树里有两个和B根节点相同的节点，
            // 判断了一个是true后，最后判断的上面如果有根节点相同但是结构不同的，这个true就会被覆盖
            return isSame(A,B);
        }
        return left||right;
    }
    //判断两颗树是否一样
    public static boolean isSame(TreeNode A,TreeNode B){
        if(A==null&&B==null){
            return true;
        }
        if(B==null&&A!=null){
            return true;
        }
        if(B!=null&&A==null){
            return false;
        }
        return A.val==B.val&&isSame(A.left,B.left)&&isSame(A.right,B.right);
    }


    //二叉树的锯齿形层次遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;    //真代表从左向右，假代表从右向左
        while(!queue.isEmpty()){
            LinkedList<Integer> inner = new LinkedList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(flag){
                    inner.addLast(node.val);
                }else{
                    inner.addFirst(node.val);
                }
            }
            flag = !flag;
            res.add(inner);
        }
        return res;
    }


    //把树看成根节点+左子树+右子树
    //树为空or根节点.val<val,那么将建立新的节点，并让新的左子树赋值为根节点
    //每次添加新的节点，一定是右子树，然后将原本的放到新添加的节点的左子树
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root==null||root.val<val){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        TreeNode right = insertIntoMaxTree(root.right,val);
        root.right = right;
        return root;
    }


    //给一个二叉树，根据每一层构成一个新的链表，返回ListNode[]
    public ListNode[] listOfDepth(TreeNode tree) {
        ListNode[] res = new ListNode[height(tree)];    //根据树的深度创建数组
        int index = 0;  //res下标,树的下标
        if(tree==null){ //如果空树直接返回
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>(); //bfs广度优先搜索
        queue.offer(tree);  //存储根节点
        while(!queue.isEmpty()){
            int size = queue.size();
            ListNode head = null;   //每一层中的链表头结点
            ListNode tail = null;   //每一层链表中的尾节点
            for(int i=0;i<size;i++){    //层序遍历二叉树
                TreeNode node = queue.poll();   //每一层取出来的节点
                if(node.left!=null){    //存左子树的节点存入队列
                    queue.add(node.left);
                }
                if(node.right!=null){   //存右子树的节点存入队列
                    queue.add(node.right);
                }
                if(head==null){ //第一次遍历去更新head和tail
                    head = new ListNode(node.val);
                    tail = head;
                }else{  //链表尾插
                    tail.next = new ListNode(node.val);
                    tail = tail.next;
                }
            }
            res[index++] = head;    //每一层保存入最终结果
        }
        return res;
    }
    public int height(TreeNode root){   //求树的深度
        if(root==null){
            return 0;
        }else{
            int left = height(root.left)+1;
            int right = height(root.right)+1;
            return Math.max(left,right);
        }
    }
}

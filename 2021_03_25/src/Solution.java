import javax.swing.tree.TreeNode;
import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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
//        TreeNode root = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(8);
//        root.left = node2;
//        root.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.right = node7;
//        node4.left = node8;
//        System.out.println(Arrays.toString(listOfDepth(root)));
        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;
        //System.out.println(pathSum(root,22));
        dfs(root);
        for(List<Integer> e:res1){
            System.out.println(e);
        }
    }

    static List<List<Integer>> res1 = new ArrayList<>();
    static LinkedList<Integer> inner = new LinkedList<>();
    public static void dfs(TreeNode root){
        if(root==null){
            return;
        }
        inner.addLast(root.val);
        if(root.left==null&&root.right==null){
            res1.add(new LinkedList<>(inner));
        }
        dfs(root.left);
        dfs(root.right);
        inner.removeLast();
    }

    static int res = 0;
    public static int pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return res;
    }
    public static void dfs(TreeNode root,int sum){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            if(sum==root.val){
                res++;
            }
            return;
        }
        sum-=root.val;
        dfs(root.left,sum);
        dfs(root.right,sum);
    }

    public static ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        ListNode[] res = new ListNode[depth(tree)];
        if(tree==null){
            return res;
        }
        queue.add(tree);
        int index = 0;
        while(!queue.isEmpty()){
            ListNode prev = null;
            ListNode head = null;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                ListNode cur1 = new ListNode(cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
                if(prev==null){
                    prev = cur1;
                    head = cur1;
                    continue;
                }
                prev.next = cur1;
                prev = cur1;
            }
            res[index++] = head;
        }
        return res;
    }
    public static int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(depth(root.left)+1,depth(root.right)+1);
    }
}
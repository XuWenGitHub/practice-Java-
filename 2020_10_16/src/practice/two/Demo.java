package practice.two;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/16 12:07
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
        TreeNode root = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(findSecondMinimumValue(root));

    }
    public int findSecondMinimumValue2(TreeNode root) {
        if(root==null){ //如果root为空，直接返回-1
            return -1;
        }
        return dfs(root,root.val);
    }
    public int dfs(TreeNode root,int rootVal){
        if(root.val!=rootVal){  //和根节点值不一样，那就是第二大节点
            return root.val;
        }
        if(root.left==null){    //如果左子树为空，根据题意，就是叶子节点，那么直接返回-1即可
            return -1;  //表示叶子结点
        }
        int left = dfs(root.left,rootVal);
        int right = dfs(root.right,rootVal);
        if(left==-1){   //左子树查找失败，直接返回右子树查找的结果
            return right;
        }
        if(right==-1){  //右子树查找失败，直接返回右子树查找的结果
            return left;
        }
        return Math.min(left,right);    //两个都查找成功了，那么返回小的哪一个
    }

    //构造一个小端
    public static int findSecondMinimumValue(TreeNode root) {
        if(root==null||root.left==null){
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)->{
            return o1-o2;
        });
        Deque<TreeNode> queue2 = new LinkedList<>();
        queue2.add(root);
        while(!queue2.isEmpty()){
            TreeNode node = queue2.poll();

            queue.offer(node.val);

            if(node.left!=null){
                queue2.offer(node.left);
                queue2.offer(node.right);
            }
        }
        queue.poll();
        while(!queue.isEmpty()){
            if(queue.peek()==root.val){
                queue.poll();
            }else{
                return queue.poll();
            }
        }
        return -1;
    }
}

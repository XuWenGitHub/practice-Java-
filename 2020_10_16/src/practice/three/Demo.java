package practice.three;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/16 12:27
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
        int a=10;
        Double d = 10d;
        d+=a;
        d = d/3;
        System.out.println(d);
        int[] arr = new int[3];
        System.out.println(arr[1]);
    }
    //求每一层的平均值，然后保存在List里面返回
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            double sum = 0;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                sum+=node.val;
            }
            res.add(sum/size);
        }
        return res;
    }

    //二叉搜索树节点最小距离
    private int min = Integer.MAX_VALUE;
    private TreeNode prev;
    //中序遍历即可
    public int minDiffInBST(TreeNode root) {
        if(root==null){
            return Integer.MAX_VALUE;
        }
        minDiffInBST(root.left);
        if(prev!=null){
            min = Math.min(min,Math.abs(root.val-prev.val));
        }
        prev = root;
        minDiffInBST(root.right);
        return min;
    }
}

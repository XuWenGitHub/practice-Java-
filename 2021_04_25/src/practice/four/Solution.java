package practice.four;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void list(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                System.out.print(poll == null ? null+" " : poll.val + " ");
                if (poll != null) {
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> treeNodes = solution.generateTrees(3);
        for(TreeNode cur:treeNodes){
            list(cur);
            System.out.println();
        }
    }
    public List<TreeNode> generateTrees(int n) {
        temp = null;
        res = new ArrayList<>();
        flag = new boolean[n+1];
        createTree(n,null,1);
        return res;
    }
    TreeNode temp; //保存构建二叉树中根节点
    List<TreeNode> res; //保存最后构建好的二叉树
    boolean[] flag; //判断1-n中是否被占用
    public void createTree(int n,TreeNode cur,int count){
        if(count==n+1){
            //复制当前树并且加到结果中
            TreeNode newRoot = treeCopy(temp);
            res.add(newRoot);
        }

        for (int i = 1; i <=n ; i++) {
            if(flag[i]){
                continue;
            }
            flag[i] = true;
            if(temp==null){
                temp = new TreeNode(i);
                createTree(n,temp,count+1);
                temp = null;
            }else{
                TreeNode parent = temp;
                TreeNode node = new TreeNode(i);
                //将node插入temp中
                while(true){
                    if(i>parent.val){
                        if(parent.right==null){
                            parent.right = node;
                            createTree(n,null,count+1);
                            parent.right = null;
                            break;
                        }else{
                            parent = parent.right;
                        }
                    }else{
                        if(parent.left==null){
                            parent.left = node;
                            createTree(n,null,count+1);
                            parent.left = null;
                            break;
                        }else {
                            parent = parent.left;
                        }
                    }
                }
            }
            flag[i] = false;    //回溯
        }
    }

    private TreeNode treeCopy(TreeNode temp) {
        if(temp ==null){
            return null;
        }
        TreeNode root = new TreeNode(temp.val);
        root.left = treeCopy(temp.left);
        root.right = treeCopy(temp.right);
        return root;
    }


}

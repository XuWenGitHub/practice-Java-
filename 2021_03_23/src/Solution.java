import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        inner = new LinkedList<>();
        res = new ArrayList<>();
        dfs(root,target);
        return res;
    }
    static LinkedList<Integer> inner;
    static List<List<Integer>> res;
    public void dfs(TreeNode root,int target){
        if(root==null){
            return;
        }
        inner.add(root.val);
        if(root.left==null&&root.right==null){
            if(target==root.val){
                res.add(new LinkedList<>(inner));
            }
        }
        dfs(root.left,target-root.val);
        dfs(root.right,target-root.val);
        inner.removeLast();
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

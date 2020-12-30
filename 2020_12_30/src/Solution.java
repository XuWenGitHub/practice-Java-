/**
 * 求根到叶子结点的数字之和,dfs
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        System.out.println(sumNumbers(root));
    }
    static int res = 0;
    public static int sumNumbers(TreeNode root) {
        res = 0;
        dfs(root,0);
        return res;
    }
    public static void dfs(TreeNode root,int puppet){
        if(root!=null){
            if(root.left==null&&root.right==null){
                puppet=puppet*10+root.val;
                res+=puppet;
                return;
            }
            dfs(root.left,puppet*10+root.val);
            dfs(root.right,puppet*10+root.val);
        }
    }
}

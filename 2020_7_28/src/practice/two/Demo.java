package practice.two;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));

        System.out.println('I'+'I');
    }
    public static int maxLen(TreeNode node){
        return maxDepth(node)+1;
    }
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=maxLen(root.left); //左子树
        int right = maxLen(root.right);
        return Math.max(left,right);
    }
}

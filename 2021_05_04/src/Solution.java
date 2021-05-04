import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateTrees(3));
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /*
    当n=1的时候，只能1
    当n=2的时候，可以放在1的根节点，或者，当前节点的右子树or当前节点的右子树的右子树
    dp[i] = dp[i-1]的所有二叉树，去将当前第n个节点添加到当前二叉搜索树的根节点or当前节点的右子树or当前节点的右子树的右子树


    */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n<=0){
            return res;
        }
        //n>0,初始状态，dp[1]=1
        TreeNode root = new TreeNode(1);
        res.add(root);
        for(int i=2;i<=n;i++){  //分治的思想解决问题
            List<TreeNode> temp = new ArrayList<>();
            for(TreeNode cur:res){  //遍历当前集合中的二叉搜索树，变化其结构
                //处理将当前值为i的节点放在根节点
                TreeNode addNode = new TreeNode(i); //这是需要当前添加到cur结构中的节点
                addNode.left = cur;
                temp.add(copyTree(addNode));
                addNode.left = null;

                TreeNode t = cur;   //去遍历当前二叉搜索树
                //将当前值为i的节点放在t的右边，并将t的right放在当前值为i的节点的左边，处理完毕，要恢复原始cur的结构
                while(t.right!=null){
                    addNode.left = t.right;
                    t.right = addNode;
                    temp.add(copyTree(cur));    //copy当前结构的二叉树到temp中转集合里面
                    //恢复cur和addNode的原始样子
                    t.right = addNode.left;
                    addNode.left = null;
                    //t往右移动
                    t = t.right;
                }

                //当t.right的右子树为null，那么是最后一种情况，把addNode放到t.right位置
                t.right = addNode;
                temp.add(copyTree(cur));
            }
            res = temp;
        }
        return res;
    }

    //深拷贝一个root为根节点的二叉树，最后返回深拷贝的二叉树的根节点
    public TreeNode copyTree(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = copyTree(root.left);
        node.right = copyTree(root.right);
        return node;
    }
}

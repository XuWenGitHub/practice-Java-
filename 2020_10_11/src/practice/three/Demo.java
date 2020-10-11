package practice.three;

/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/11 15:03
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
        
    }
    private TreeNode res;

    //二叉树中两个节点的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.res = null;    //给res初始化一下
        dfs(root,p,q);
        return this.res;
    }

    //深度优先搜索
    public boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){ //当树为空树
            return false;   //空树肯定没有p和q的公共节点
        }
        //后序遍历,这样我们就可以从下面往上找，因为最近的公共祖先一定是在靠近底端的
        boolean leftSearch = dfs(root.left,p,q); //去左子树找
        boolean rightSearch = dfs(root.right,p,q);   //去右子树找
        //现在已经递归到树的最深处，现在从树的下面往上判断，肯定最先遇到最近公共祖先
        //两种情况说明是公共祖先
        //在左子树找到（p、q）其中一个，再右子树找到（p、q）另外一个，这是一种情况
        //如果root是（p、q）其中一个节点，另一个节点在root左或右子树即可
        if((leftSearch&&rightSearch)||((root.val==p.val||root.val==q.val)&&(leftSearch||rightSearch))){
            res = root;
        }
        //因为所有节点的值唯一，而且自己也可以是自己的祖先
        //那么只要左子树找到或者右子树找到或者root的值==q或p，那都是祖先
        return leftSearch||rightSearch||(root.val==q.val||root.val==p.val);
    }

}

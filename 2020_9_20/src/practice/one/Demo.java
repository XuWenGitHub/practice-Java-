package practice.one;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/20 15:08
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        final var root = new TreeNode(5);
        final var node1 = new TreeNode(3);
        final var node2 = new TreeNode(6);
        final var node3 = new TreeNode(2);
        final var node4 = new TreeNode(4);
        final var node5 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;
        System.out.println(height(root,node4));
        System.out.println(height(root));
        System.out.println(lowestCommonAncestor(root,node5,node4));

        System.out.println(parent(root,new TreeNode(1)));
    }

    //找一颗二叉排序树(二叉搜索树)中，p和q的最近公共父节点
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果p的子树是q那么直接返回p即可
        if(p.left==q||p.right==q){
            return p;
        }
        //如果q的子树是p那么直接返回q即可
        if(q.left==p||q.right==p){
            return q;
        }
        TreeNode pParent=p; //找p的父节点
        TreeNode qParent = q;   //找q的父节点

        while(pParent.val!=qParent.val){
            if(pParent==root||qParent==root){
                return root;
            }
            //如果p的父节点的深度，大于q的父节点的深度，那么找p的父节点的父节点
            if(height(root,pParent)>height(root,qParent)){
                pParent = parent(root,pParent);
            }else{
                //如果q的父节点的深度，大于p的父节点的深度，那么找q的父节点的父节点
                qParent = parent(root,qParent);
            }

        }
        return pParent;
    }
    //二叉搜索树中求一个节点在一颗树中的深度
    public static int height(TreeNode root,TreeNode target){
        if(root.val==target.val){
            return 1;
        }else if(root.val<target.val){
            return root.right==null?0:(height(root.right,target)+1);
        }else{
            return root.left==null?0:(height(root.left,target)+1);
        }
    }
    //求一颗树的高度
    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max((root.left==null?0:height(root.left)),(root.right==null?0:height(root.right)))+1;
    }

    //二叉搜索树(二叉排序树)查找一个节点的父节点
    public static TreeNode parent(TreeNode root,TreeNode target){
        if(root.left.val==target.val||root.right.val==target.val){
            return root;
        }
        if(root.val<target.val){
            return parent(root.right,target);
        }else if(root.val>target.val){
            return parent(root.left,target);
        }else{
            return null;    //说明没有找到target节点
        }
    }
}

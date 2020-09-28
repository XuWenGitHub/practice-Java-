package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: TreeTool
 * @Author: XuWen
 * Date: 2020/9/27 19:34
 * Introduce:
 */
public class TreeTool {
    //在二叉树中找值为v的节点，找到返回该节点，找不到返回null
    public static TreeNode contains2(TreeNode root,int v){
        if(root==null){ //当树为空
            return null;
        }else{  //当树不为空
            //把一棵树变成=根节点+左子树+右子树
            if(root.val==v){
                return root;
            }else{
                //先去左子树找
                TreeNode search = contains2(root.left,v);
                if(search==null){   //当左子树没有找到
                    search = contains2(root.right,v);   //左子树找不到再去右子树找
                }
                return search;
            }
        }
    }


    //给定一颗二叉树，同时给定一个v。问：这颗二叉树中是否包含这个V
    //把树看成：根节点中有v？左子树中有v？右子树中有V？
    public static boolean contains(TreeNode root,int v){
        if(root==null){ //树为空树
            return false;
        }else { //树不为空树
            if (root.val == v) {  //当前树的根是否==v
                return true;
            } else {  //树的根节点值不等于v，树不是空树，就去左子树和右子树找
                boolean leftTree = contains(root.left, v);
                boolean rightTree = false;
                if (!leftTree) { //只要左子树找到了，就不去右子树里面找
                    rightTree = contains(root.right, v);
                }
                return leftTree || rightTree;
            }
        }
    }

    //求一棵树的高度
    public static int height(TreeNode root){
        if(root==null){ //空树
            return 0;
        }else if(root.left==null&&root.right==null){    //只有一个节点的树
            return 1;
        }else {
            int leftHeight = height(root.left)+1;
            int rightHeight = height(root.right)+1;
            return Math.max(leftHeight,rightHeight);
        }
    }

    //给定一棵二叉树，求该二叉树，第k层的节点个数
    // （根的层级设定为1，k>=1)
    public static int sumTreeNodeK(TreeNode root,int k){
        if(root==null){ //空树的节点个数
            return 0;
        }else if(k==1){ //root不是空树，但k==1
            return 1;
        }else{  //其他情况
            int sumLeftNodeK = sumTreeNodeK(root.left,k-1);
            int sumRightNodeK = sumTreeNodeK(root.right,k-1);
            return sumLeftNodeK+sumRightNodeK;
        }
    }


    //非递归求叶子结点的个数
    public static int sumLeafNode2(TreeNode root){
        leafNode=0; //要归0，不然一个程序求两次就变成了double倍了
        preOrder2(root);
        return leafNode;
    }
    static int leafNode = 0;
    private static void preOrder2(TreeNode root){
        if(root!=null){
            if(root.left==null&&root.right==null){
                leafNode++;
            }
            preOrder2(root.left);
            preOrder2(root.right);
        }
    }


    //递归求叶子结点的个数
    public static int sumLeafNode(TreeNode root){
        if(root==null){ //空树
            return 0;
        }
        if(root.left==null&&root.right==null){  //树中只有一个节点的树
            return 1;
        }else{  //有子树的树：树的叶子结点个数 = 左子树的叶子结点个数+右子树的叶子结点个数
            int leftLeafNode =0;
            int rightLeafNode=0;
            leftLeafNode = sumLeafNode(root.left);
            rightLeafNode = sumLeafNode(root.right);
            return leftLeafNode+rightLeafNode;
        }
    }

    /**
     * 求一颗树的节点个数
     * 因为一棵树的节点个数=根节点+左子树的节点个数+右子树的节点个数
     * @param root  树的根节点
     * @return  树的节点个数
     */
    public static int sumTreeNode(TreeNode root){
        if(root==null){
            return 0;   //递归出口
        }else {
            int r = 1;
            int leftTree = sumTreeNode(root.left);
            int rightTree = sumTreeNode(root.right);
            return r+leftTree+rightTree;
        }
    }

    /**
     * 非递归实现求一棵树中的节点个数
     */
    private static int sum;
    public static int sumTreeNode2(TreeNode root){
        sum=0;
        preOrder(root);
        return sum;
    }
    private static void preOrder(TreeNode root){
        if(root!=null){
            sum++;
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}

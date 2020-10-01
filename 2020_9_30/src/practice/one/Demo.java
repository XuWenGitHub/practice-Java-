package practice.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/30 10:26
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        TreeNode nodeB = new TreeNode('B');
        TreeNode nodeC = new TreeNode('C');
        TreeNode nodeD = new TreeNode('D');
        TreeNode nodeE = new TreeNode('E');
        TreeNode nodeF = new TreeNode('F');
        TreeNode nodeG = new TreeNode('G');
        TreeNode nodeH = new TreeNode('H');
        TreeNode nodeI = new TreeNode('I');
        TreeNode nodeJ = new TreeNode('J');
        root.left = nodeB;
        root.right = nodeC;
        nodeB.left = nodeD;
        nodeC.left = nodeE;
        nodeC.right = nodeF;
        nodeD.right = nodeG;
        nodeF.left = nodeH;
        nodeF.right = nodeI;
        nodeG.left = nodeJ;
        System.out.println(preOrder(root));
        System.out.println(infixOrder(root));
        System.out.println(postOrder(root));
    }
    //给定一个二叉树，检查它是否是镜像对称的。
    public static boolean isSymmetric(TreeNode root){
        if(root==null){ //空树，对称
            return true;
        }else { //不是空树，就判断左子树和右子树是否对称
            return isSymmetric(root.left,root.right);
        }
    }
    //给定两个二叉树，判断它们是否是镜像对称的
    public static boolean isSymmetric(TreeNode p,TreeNode q){
        if(p==null&&q==null){   //两棵树都为空树，返回true
            return true;
        }
        if(p==null||q==null){   //其中一棵树为空树，另一颗不为空树，返回false
            return false;
        }
        //走到这里，p和q两棵树都不是空树
        //那么我们需要判断其根节点是否相同，p的左子树和q的右子树是否相同，p的右子树和q的左子树是否相同
        return p.val==q.val&&isSymmetric(p.left,q.right)&&isSymmetric(p.right,q.left);
    }


    //判断一棵树是否是平衡二叉树
    //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1
    public static boolean isBalanced(TreeNode root){
        if(root==null){ //空树
            return true;
        }
        int leftHeight = maxDepth(root.left);   //root为根节点左子树的高度
        int rightHeight = maxDepth(root.right); //以root为根节点右子树的高度
        if(Math.abs(leftHeight-rightHeight)<=1&&isBalanced(root.left)&&isBalanced(root.right)){
            return true;    //如果左子树和右子树高度的差值的绝对值<=1，那么说明这个节点满足条件
            //&&isBalanced(root.left)&&isBalanced(root.right)，满足第一个，再判断左子树和右子树中的节点是否满足条件
        }
        return false;
    }

    //求一个树的最大深度
    public static int maxDepth(TreeNode root) {
        if(root==null){ //空树高度为0
            return 0;
        }else{  //如果不是空树，就分为根节点高度+（左子树高度和右子树高度）中最大高度
            int r = 1;  //根节点高度
            int leftHeight = maxDepth(root.left);   //左子树高度
            int rightHeight = maxDepth(root.right); //右子树高度
            return r+Math.max(leftHeight,rightHeight);
        }
    }

    /*
    给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
    s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
    （1）先在s树中找t节点，如果找到了，判断找到的当前节点为根节点的树是否和t树相同
    如果相同，返回true，如果不相同，就继续找t节点
     */
    public static boolean isSubtree(TreeNode s,TreeNode t){
           if(t==null){
               return true;
           }else{
               return search(s,t);
           }
    }
    //在s树中找t节点,找到后，判断是否和t树相同，不相同继续找
    public static boolean search(TreeNode s,TreeNode t){
        if(s==null){    //s树为空树,返回false
            return false;
        }else{
            if(s.val==t.val){   //判断当前根节点是否和t节点相同
                if(isSameTree(s,t)){    //找到后，判断是否树相同
                    return true;    //如果相同返回true
                }
            }
            if(search(s.left,t)){   //现在去左子树里面找，是否有相同子树
                return true;
            }
            //根节点和左子树都没有找到的话，现在去右子树去找
            return search(s.right,t);
        }
    }

    /*
    给定两个二叉树，编写一个函数来检验它们是否相同。
    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    把p和q都看成树
    （1）p树和q树都为空树  return true
    （2）p树和q树其中一个为空树，另一个不为空树  return false
    （3）p树和q树都不为空树，那么要判断p树的根节点，左子树和右子树是否和q树相等
     */
    public static boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null){   //p树和q树都为空树  return true
            return true;
        }
        if(p==null||q==null){//p树和q树其中一个为空树，另一个不为空树  return false
            return false;
        }
        //走到这里说明p树和q树都不为空树
        return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }

    //后序遍历
    public static List<Character> postOrder(TreeNode root){
        List<Character> list = new ArrayList<>();
        if(root!=null){
            //求左子树
            final var list1 = postOrder(root.left);
            list.addAll(list1);
            //求右子树
            final var list2 = postOrder(root.right);
            list.addAll(list2);
            //添加根节点
            list.add(root.val);
        }
        return list;
    }
    //中序遍历
    public static List<Character> infixOrder(TreeNode root){
        List<Character> list = new ArrayList<>();
        if(root!=null){
            List<Character> leftList = infixOrder(root.left);
            list.addAll(leftList);
            list.add(root.val);
            final var characters = infixOrder(root.right);
            list.addAll(characters);
        }
        return list;
    }
    //前序遍历，返回List
    public static List<Character> preOrder(TreeNode root){
        List<Character> list = new ArrayList<>();
        if(root!=null){
            list.add(root.val);
            List<Character> leftList = preOrder(root.left);
            list.addAll(leftList);
            List<Character> rightList = preOrder(root.right);
            list.addAll(rightList);
        }
        return list;
    }
}

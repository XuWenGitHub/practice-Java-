package practice.two;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

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
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/20 16:11
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        final var root = new TreeNode(3);
        final var node5 = new TreeNode(5);
        final var node1 = new TreeNode(1);
        final var node6 = new TreeNode(6);
        final var node2 = new TreeNode(2);
        final var node0 = new TreeNode(0);
        final var node8 = new TreeNode(8);
        final var node7 = new TreeNode(7);
        final var node4 = new TreeNode(4);
        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left=node0;
        node1.right=node8;
        node2.left=node7;
        node2.right=node4;
        System.out.println(lowestCommonAncestor(root, node5, node4));
        //System.out.println(height(root,node5));
        //System.out.println(height(root,node4));
        System.out.println(parent(root,root));
    }
    //寻找一颗二叉树中两个节点的最近公共父节点
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.left==q||p.right==q){
            return p;
        }
        if(q.left==p||q.right==p){
            return q;
        }
        TreeNode pParent = p;
        TreeNode qParent = q;
        while(pParent!=qParent){
            if(pParent==root||qParent==root){
                return root;
            }
            if(height(root,pParent)>height(root,qParent)){
                pParent = parent(root,pParent);
            }else{
                qParent = parent(root,qParent);
            }
        }
        return pParent;
    }
    //在一棵二叉树中，寻找一个节点(target)的在root中的深度
    public static int height(TreeNode root,TreeNode target){
        //一层一层遍历树，然后如果遇到target，返回其层数
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i=1;
        while(!queue.isEmpty()){
            if(queue.contains(target)){
                return i;
            }
            Queue<TreeNode> list = new LinkedList<>();  //保存下一层的节点
            for(TreeNode node:queue){
                if(node.left!=null){
                    list.add(node.left);
                }
                if(node.right!=null){
                    list.add(node.right);
                }
            }
            queue = list;
            i++;    //下一层了
        }
        return -1;  //说明没有找到target
    }
    //寻找二叉树中一个节点的父节点,根节点的父节点是null
    public static TreeNode parent(TreeNode root,TreeNode target){
        if(root==null){
            return null;
        }
        if(root.left==target||root.right==target){
            return root;
        }
        TreeNode find = parent(root.left,target);
        if(find==null){
            find = parent(root.right,target);
        }
        return find;
    }
}

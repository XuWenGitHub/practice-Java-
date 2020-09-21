package practice.four;

import java.util.ArrayList;
import java.util.List;

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
 * @PackgeName: practice.four
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/20 21:00
 * Introduce:
 */
public class Demo {
    //树一层一层的遍历
    public static void list(TreeNode root){
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            //遍历当前层
            for(TreeNode node:nodes){
                System.out.print(node);
            }
            System.out.println();
            //存入下一层
            List<TreeNode> list = new ArrayList<>();
            for(TreeNode node:nodes){
                if(node.left!=null){
                    list.add(node.left);
                }
                if(node.right!=null){
                    list.add(node.right);
                }
            }
            nodes = list;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        root.left = node2;
        root.right=node7;
        node2.left = node1;
        node2.right = node3;
        node7.left=node6;
        node7.right=node9;
        list(root);
        System.out.println("二叉树的镜像");
        list(mirrorTree(root));
        //List<TreeNode> list = new ArrayList<>();

    }

    //求一个二叉树的镜像，就是左右交换
    //一层一层的遍历,null也要保存
    //先把每一层的节点，全部存入ArrayList里面，最后通过2n-1和2n-2构造新的树
    public static TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        //先把每一层的节点，逆序存入list里面
        List<TreeNode> nodes = getReverseNode(root);

        return getTree(nodes);
    }
    //将一个TreeNode集合，变成一颗树
    public static TreeNode getTree(List<TreeNode> nodes){
        //TreeNode node = new TreeNode(nodes.get(0));
        for(int i=0;i<nodes.size();i++){
            TreeNode node = nodes.get(i);
            if(node!=null) {
                if (2 * i + 1 < nodes.size()) {
                    node.left = nodes.get(2 * i + 1);
                }
                if (2 * i + 2 < nodes.size()) {
                    node.right = nodes.get(2 * i + 2);
                }
            }
        }
        return nodes.get(0);
    }
    //一层一层的遍历，每一层相反的存入list里面
    public static List<TreeNode> getReverseNode(TreeNode root){
        List<TreeNode> nodes = new ArrayList<>();

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while(!list.isEmpty()){
            boolean flag = true;
            //把当前list中的节点逆序存入nodes里面
            for(int i=list.size()-1;i>=0;i--){
                nodes.add(list.get(i));    //当前层保存nodes集合
            }
            //定义新的list，然后存入下一层，然后更改list
            List<TreeNode> newList = new ArrayList<>();
            for(TreeNode node:list){
                //if(node.left!=null){
                if(node==null){
                    newList.add(null);
                    newList.add(null);
                    continue;
                }
                    newList.add(node.left);
                    newList.add(node.right);
                    flag = false;
            }
            list = newList;
            if(flag){
                break;
            }
        }
        return nodes;
    }
}

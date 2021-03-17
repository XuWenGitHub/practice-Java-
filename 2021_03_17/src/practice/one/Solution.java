package practice.one;

import java.util.*;

public class Solution {
    static class TreeNode{
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
    public static void list(Deque<TreeNode> deque){ //遍历二叉树
        for(TreeNode element:deque){
            System.out.print(element.val+" ");
        }
        System.out.println();
    }

    //找一颗二叉树的距离最远的两个点
    //（1）找到距离最远的两个点
    //（2）打印两个最远点的路径
    //（3）最远的距离，不止有一对，多对
    public static Map<Deque<TreeNode>,Integer> map;
    public static int maxLen;
    public static List<List<TreeNode>> maxLenTreeNode(TreeNode root){
        map = new HashMap<>();  //存放路径->对应的长度
        List<List<TreeNode>> res = new ArrayList<>();   //存放最后的多个结果
        maxLen = Integer.MIN_VALUE;
        preOrder(root);
        for(Map.Entry<Deque<TreeNode>,Integer> entry:map.entrySet()){    //遍历map
            if(entry.getValue()==maxLen){
                Deque<TreeNode> key = entry.getKey();
                list(key);  //打印最长的路径
                ArrayList<TreeNode> treeNodes = new ArrayList<>();  //保存路径的头结点和尾节点
                treeNodes.add(key.getFirst());
                treeNodes.add(key.getLast());
                res.add(treeNodes); //将头结点和尾节点的集合添加到最后返回的集合
            }
        }
        return res;
    }
    //后序遍历二叉树每个节点
    public static void preOrder(TreeNode root){
        if(root!=null){
            preOrder(root.left);
            preOrder(root.right);
            Deque<TreeNode> deque = maxLen(root);   //去算出带有root节点的最长路径
            int len = deque.size(); //最长路径的长度
            if(len>maxLen){ //更新最大长度
                maxLen = len;
            }
            map.put(deque,len); //map中添加最长长度
        }
    }
    //找到以当前root为根节点，最远的路径保存到双端队列,并且更新最大长度
    public static Deque<TreeNode> maxLen(TreeNode root){
        Deque<TreeNode> res = new LinkedList<>();
        method(root.left,res,true); //添加左子树最长路径
        res.addLast(root);  //添加根节点
        method(root.right,res,false);   //添加右子树最长路径
        return res;
    }
    //flag:true代表头插，false代表尾插，找到当前树最远的路径
    public static void method(TreeNode root,Deque<TreeNode> res,boolean flag){
        if(root!=null){
            if(flag){
                res.addFirst(root);
            }else{
                res.addLast(root);
            }
            int left = maxDepth(root.left); //左子树的深度
            int right = maxDepth(root.right);   //右子树的深度
            if(left>right){
                method(root.left,res,flag);
            }else if(left<right){
                method(root.right,res,flag);
            }else{  //这里有点小问题，还没有想清楚
                method(root.left,res,flag);
            }
        }
    }
    public static int maxDepth(TreeNode root) {
        if(root!=null){
            return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left=node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;

        //测试带有root节点的二叉树最长的路径
        Deque<TreeNode> deque = new LinkedList<>();
        method(root.left,deque,true);
        deque.addLast(root);
        method(root.right,deque,false);
        System.out.println(deque);  //[TreeNode{val=6}, TreeNode{val=5}, TreeNode{val=2}, TreeNode{val=1}, TreeNode{val=3}]

        List<List<TreeNode>> lists = maxLenTreeNode(root);
        for(List<TreeNode> list:lists){
            System.out.println(list);
            /*
            输出：
            6 5 2 1 3
            [TreeNode{val=6}, TreeNode{val=3}]
             */
        }
    }
}

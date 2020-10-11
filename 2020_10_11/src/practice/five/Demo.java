package practice.five;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: practice.five
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/11 19:47
 * Introduce:根据一棵树的前序遍历与中序遍历构造二叉树
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

    public List<Integer> getList(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int element:arr){
            list.add(element);
        }
        return list;
    }
    /*
    前序遍历 preorder = [3,9,20,15,7]   根节点+左子树+右子树
    中序遍历 inorder = [9,3,15,20,7]    左子树+根节点+右子树
    构造二叉树
    根据前序可以知道根节点在哪里，如上，目前根节点是3
    根据中序遍历可以知道左子树有几个，右子树有几个
    然后不断的递归，前序和中序序列永远都是相等的
    当前序序列只有一个的时候，那么就可以直接造节点，如果前序序列为空，那么就是null
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(getList(preorder),getList(inorder));
    }
    public TreeNode buildTree(List<Integer> preorder,List<Integer> inorder){
        if(preorder.isEmpty()){
            return null;    //说明是空树
        }
        //取出根节点
        int rootVal = preorder.get(0);
        //算出左子树有多少个
        int index = inorder.indexOf(rootVal);
        TreeNode root = new TreeNode(rootVal);  //构造根节点
        if(preorder.size()==1){ //说明该树只有一个节点
            return root;    //返回根节点
        }
        //前序遍历结果左子树的元素序列
        List<Integer> leftPreOrder = preorder.subList(1,index+1);
        //前序遍历结果右子树的元素序列
        List<Integer> rightPreOrder = preorder.subList(index+1,preorder.size());
        //中序遍历结果左子树的元素序列
        List<Integer> leftInfixOrder = inorder.subList(0,index);
        //中序遍历结果右子树的元素序列
        List<Integer> rightIndexOrder = inorder.subList(index+1,inorder.size());

        //递归生成左右子树
        root.left = buildTree(leftPreOrder,leftInfixOrder);
        root.right = buildTree(rightPreOrder,rightIndexOrder);
        return root;
    }


    //用数组下标来表示
    public int indexOf(int[] arr,int findVal){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==findVal){
                return i;
            }
        }
        return -1;
    }
    public int[] getArr(int[] arr,int start,int end){
        int[] newArr = new int[end-start];

        int index = 0;
        for(int i=start;i<end;i++){
            newArr[index] = arr[i];
            index++;
        }
        return newArr;
    }
    /*
    前序遍历 preorder = [3,9,20,15,7]   根节点+左子树+右子树
    中序遍历 inorder = [9,3,15,20,7]    左子树+根节点+右子树
    构造二叉树
    根据前序可以知道根节点在哪里，如上，目前根节点是3
    根据中序遍历可以知道左子树有几个，右子树有几个
    然后不断的递归，前序和中序序列永远都是相等的
    当前序序列只有一个的时候，那么就可以直接造节点，如果前序序列为空，那么就是null
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;    //空树
        }
        int rootVal = preorder[0];
        int index = indexOf(inorder,rootVal);   //就是左子树的个数
        TreeNode root = new TreeNode(rootVal);
        if(preorder.length==1){
            return root;
        }
        int[] leftPreOrder = getArr(preorder,1,index+1);
        int[] rightPreOrder = getArr(preorder,index+1,preorder.length);
        int[] leftInfixOrder = getArr(inorder,0,index);
        int[] rightInfixOrder = getArr(inorder,index+1,inorder.length);
        root.left = buildTree(leftPreOrder,leftInfixOrder);
        root.right = buildTree(rightPreOrder,rightInfixOrder);
        return root;

        //return buildTree(getList(preorder),getList(inorder));
    }
}

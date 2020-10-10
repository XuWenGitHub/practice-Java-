package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: Main
 * @Author: XuWen
 * Date: 2020/10/10 19:24
 * Introduce:
 */
import java.util.*;
import java.lang.String;
public class Main{
    static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode(char val){
            this.val = val;
        }
    }
    //输入一个二叉树前序遍历的字符串（带null的）null用#代替，然后还原一颗二叉树，并让其中序遍历
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //测试案例其中一个输入：abc##de#g##f###
        //输出c b e g d f a
        char[] arr = str.toCharArray();
        List<Character> in = new ArrayList<>();
        for(char element:arr){
            in.add(element);
        }
        //List<Character> in = Arrays.asList((Character[]) str.toCharArray());
        List<Character> out = new ArrayList<>();
        TreeNode root = buildTree2(in,out);
        infixOrder(root);
    }

    /**
     * 根据带空节点的前序序列来构建二叉树
     * @param in    传入的带空节点的前序遍历序列
     * @param out   是一个空的list，用来存储剩余的序列
     * @return  构建的一颗二叉树的根
     */
    public static TreeNode buildTree3(List<Character> in,List<Character> out){
        if(in.isEmpty()){   //说明序列为空，树为空树即可
            return null;
        }
        char rootVal = in.remove(0);    //序列中第一个删除掉，并取出来
        //判断是否为#，#代表null
        if(rootVal=='#'){
            //如果为#了,就是空树
            //直接把in中其他的加入到out里面，因为前面remove了
            //剩余的就是in中的了
            out.addAll(in);
            return null;
        }

        //走到这里说明取出来的字符不是#
        //那么以该字符为构建树，返回
        TreeNode root = new TreeNode(rootVal);

        //构建root的左子树
        //这里in由于刚才调用过remove(0)了，所有，已经不包括第一个元素了，
        //直接拿这in去构建左子树，同时要创建一个rightOut集合，
        //来存储创建左子树后，剩余的元素，下面好拿这剩余的元素创建右子树
        List<Character> rightOut = new ArrayList<>();
        TreeNode rootLeft = buildTree3(in,rightOut);

        //构建root的右子树
        //这里的rightOut就是构建右子树用的序列
        //构建右子树剩下的序列就是构建整棵树剩下的序列
        TreeNode rootRight = buildTree3(rightOut,out);

        root.left = rootLeft;
        root.right = rootRight;
        return root;
    }

    /**
     * 给你一个二叉树前序遍历带null的结果，给的字符串，null用#代表，还原二叉树
     * @param in    二叉树带null的前序遍历
     * @param out   因为需要递归来，保存剩余的字符,最开始是空的list
     * @return  还原的二叉树
     */
    public static TreeNode buildTree2(List<Character> in,List<Character> out){
        if(in.isEmpty()){
            return null;    //说明前序遍历的结果为空，那么就是空树
        }
        //先取出in的第一个字符
        char rootVal = in.remove(0);
        if(rootVal=='#'){   //表示代表null，那么返回null即可
            out.addAll(in);   //因为上面取出了第一个，直接把剩余的给out即可
            return null;
        }
        //代表是字符，那么它会有根节点，左子树右子树
        TreeNode root = new TreeNode(rootVal);  //根节点
        //去递归得到其左子树
        List<Character> rightOut = new ArrayList<>();   //递归得到左子树的同时把剩于的字符保存到rightOut
        TreeNode rootLeft = buildTree2(in,rightOut);   //递归得到其左子树
        TreeNode rootRight = buildTree2(rightOut,out);  //递归得到其右子树
        root.left = rootLeft;
        root.right = rootRight;
        return root;
    }

    //把一个带null的前序遍历的二叉树，还原一颗二叉树，前序遍历的结果是字符串（#代表null）
    public static TreeNode buildTree(List<Character> in,List<Character> out){
        if(in.isEmpty()){
            return null;    //没有序列，in为空，说明是空树，out也为空
        }

        char rootVal = in.remove(0);
        if(rootVal=='#'){
            out.addAll(in);
            return null;
        }
        //如果走到这里说明不是#,是字母，那么就是节点，就会有根节点左子树和右子树
        TreeNode root = new TreeNode(rootVal);
        List<Character> rightOut = new ArrayList<>();
        TreeNode left = buildTree(in,rightOut);
        TreeNode right = buildTree(rightOut,out);
        root.left = left;
        root.right = right;
        return root;
    }

    //中序遍历
    public static void infixOrder(TreeNode root){
        if(root!=null){
            infixOrder(root.left);
            System.out.print(root.val+" ");
            infixOrder(root.right);
        }
    }
}

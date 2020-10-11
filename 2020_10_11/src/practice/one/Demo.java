package practice.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/11 8:56
 * Introduce:
 * 编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。
 * 例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。
 * 建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
 */
public class Demo {
    static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    //将字符串转成List存每一个字符
    public static List<Character> getList(String s){
        List<Character> list = new ArrayList<>();
        for(char c:s.toCharArray()){
            list.add(c);
        }
        return list;
    }
    //二叉树的中序遍历
    public static void infixOrder(TreeNode root){
        if(root!=null){
            infixOrder(root.left);
            System.out.print(root.val+" ");
            infixOrder(root.right);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = "abc##de#g##f###";
        List<Character> chars = getList(str);
        List<Character> out = new ArrayList<>();
        TreeNode root = createTree(chars,out);
        infixOrder(root);
    }
    /**
     * ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。
     * 将字符List转成树来返回
     * @param in    传入的字符序列
     * @param out   最开始是空的字符序列，然后每次变成剩下的字符
     * @return  返回最后形成的树
     */
    public static TreeNode createTree(List<Character> in,List<Character> out){
        //当in为空，那说明是个空树，返回null即可
        if(in.isEmpty()){
            return null;
        }
        //先取出第一个字符，直接remove出来
        char rootVal = in.remove(0);
        //现在判断是否是#
        if(rootVal=='#'){   //那说明代表的是null
            out.addAll(in); //因为前面已经删除了第一个，这里就不用再删除了
            return null;    //因为#代表null，所以返回null，即可
        }

        //说明是一个字符，那么有根节点+左子树+右子树
        TreeNode root = new TreeNode(rootVal);  //根节点
        //去递归实现左子树，但是要重新造一个List，保存左子树实现完后的剩余字符，用剩余的字符去实现右子树
        List<Character> rightOut = new ArrayList<>();
        TreeNode rootLeft = createTree(in,rightOut);
        //去递归实现左子树，最后剩下的就是out，因为树弄完了，就是最后剩下的
        TreeNode rootRight = createTree(rightOut,out);
        //给root连接去左子树和右子树，最后返回根节点即可
        root.left = rootLeft;
        root.right = rootRight;
        return root;
    }

}

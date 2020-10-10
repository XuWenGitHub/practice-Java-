package practice.one;



import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/9 19:23
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
    }
    //根据给的一棵树的字符串的前序遍历（带null的），构建二叉树，然后返回
    //null存#
    public static TreeNode buildTree(List<Character> in,List<Character> out){
        if(in.isEmpty()){
            //没有序列,只能是空树
            //out仍然是空的
            return null;
        }

        //in 不是Empty的了
        char rootVal = in.remove(0);
        if(rootVal=='#'){
            //剩下的就是in去除第一个元素(#)
            //in由于调用了remove，已经把第一个元素(下标为0)取出了
            out.addAll(in);
            //遇到#一定是空树
            return null;
        }

        //rootVal一定不是#，构建不同的节点和以该节点为根的树
        TreeNode root = new TreeNode(rootVal);

        //这里的in由于刚才调用
        List<Character> rightOut = new ArrayList<>();   //构建一个空的，去构建左子树时，剩余的字符
        TreeNode left = buildTree(in,rightOut);

        //构建root的右子树
        //这里的rightOut就是构建右子树用的序列
        //构建右子树剩下的序列就是构建整颗树
        TreeNode right = buildTree(rightOut,out);
        root.left = left;
        root.right = right;
        return root;
    }

    //判断一颗树是否为完全二叉树
    public static boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //把二叉树中所有元素，包括null，层序遍历，存入queue,直到遇到null结束
        while(true){
            //不需要考虑队列是否为空，不可能
            TreeNode node = queue.poll();
            if(node==null){
                break;
            }
            //不管是不是null，全添加进去
            queue.add(node.left);
            queue.add(node.right);
        }
        //检查队列中，是不是全为null，如果全为null，是完全二叉树，反之不是
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null){ //还不能说明是完全二叉树
            }else{//一个节点不为null，可以说明不是完全二叉树
                return false;
            }
        }
        return true;
    }

    //层序遍历二叉树，最后保存到list里面返回
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();   //返回最后的结果
        if(root==null){
            return res;
        }
        Queue<TreeNode> outer = new LinkedList<>(); //存放每一层的节点
        outer.offer(root);  //存放根节点
        while(!outer.isEmpty()){    //只要不为空
            List<Integer> inlayer = new LinkedList<>(); //outer的元素值
            int len = outer.size(); //当前层数的个数
            for(int i=0;i<len;i++){ //遍历当层的节点
                TreeNode node = outer.poll();
                inlayer.add(node.val);
                if(node.left!=null){
                    outer.offer(node.left);
                }
                if(node.right!=null){
                    outer.offer(node.right);
                }
            }
            res.add(inlayer);
        }
        return res;
    }


}
